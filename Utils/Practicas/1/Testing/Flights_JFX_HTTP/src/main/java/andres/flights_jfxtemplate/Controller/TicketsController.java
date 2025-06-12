package andres.flights_jfxtemplate.Controller;

import andres.flights_jfxtemplate.Bridges.Ticket_in_Passenger;
import andres.flights_jfxtemplate.DTO.TicketDTO;
import andres.flights_jfxtemplate.Entity.AirportEntity;
import andres.flights_jfxtemplate.Entity.FlightEntity;
import andres.flights_jfxtemplate.Service.FlightService;
import andres.flights_jfxtemplate.Service.TicketService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class TicketsController {
    @FXML
    private DatePicker datePicker;
    @FXML
    public ComboBox<AirportEntity> originCombo;
    @FXML
    private ComboBox<AirportEntity> destinationCombo;
    @FXML
    private ComboBox<FlightEntity> flightCombo;
    @FXML
    private ComboBox<String> typeFlightCombo;
    @FXML
    private TextField passportField;
    @FXML
    private Button logButton;
    @FXML
    public Label logLabel;

    private String errorMessage;
    private boolean formHasErrors;

    public FlightService flightService = new FlightService();
    public TicketService ticketService = new TicketService();

    @FXML
    public void initialize() {
        // check server_status
        checkServerStatus();

        // load combo_box
        loadDate();
        loadOrigins();
        loadTypeFlight();

        // event_listeners
        listenerOrigins();
        listenerDestination();
        listenerTypeFlights();
    }

    private void loadDate() {
        datePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()));
            }
        });
        datePicker.setValue(LocalDate.now());
    }

    public void loadOrigins() {
        originCombo.getItems().addAll(flightService.getAllOrigins());
    }

    // EVENT LISTENERS
    public void listenerOrigins() {
        originCombo.setOnAction(event -> {
            AirportEntity selectedOrigin = originCombo.getSelectionModel().getSelectedItem();
            if (selectedOrigin != null) {
                destinationCombo.getItems().clear();
                List<AirportEntity> destinations = flightService.getDestinationsByOrigin(selectedOrigin.getCode());
                destinationCombo.getItems().addAll(destinations);
            }
        });
    }

    public void listenerDestination() {
        destinationCombo.setOnAction(event -> {
            AirportEntity selectedOrigin = originCombo.getSelectionModel().getSelectedItem();
            AirportEntity selectedDestination = destinationCombo.getSelectionModel().getSelectedItem();
            if (selectedOrigin != null || selectedDestination != null) {
                flightCombo.getItems().clear();
                List<FlightEntity> flights = flightService.getAllFlights(selectedOrigin.getCode(), selectedDestination.getCode());
                flightCombo.getItems().addAll(flights);
            }
        });
    }

    private void loadTypeFlight() {
        typeFlightCombo.getItems().add("♪");
        typeFlightCombo.getItems().add("⏱");
        typeFlightCombo.getItems().add("✈");
    }

    public void listenerTypeFlights() {
        typeFlightCombo.setOnAction(event -> {
            int selectedIndex = typeFlightCombo.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < flightCombo.getItems().size()) {
                flightCombo.getSelectionModel().select(selectedIndex);
            }
        });
    }

    // FUNCIONALIDAD DE LOS BOTONES 'CREATE_USER' Y 'CREATE_TICKET'
    public void createNewUser(ActionEvent event) {
        try {
            String passport = passportField.getText();
            if (passport.isEmpty()) {
                showWarningMessage("Error", "New user can't be created.\nPassport must be 8 characters long.");
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/nvg-passenger-creation.fxml"));
            Parent nuevaVista = loader.load();

            Ticket_in_Passenger controller = loader.getController();
            controller.setPassportno(passport);

            Scene nuevaEscena = new Scene(nuevaVista);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(nuevaEscena);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createNewTicket(ActionEvent event) {
        FlightEntity flight = flightCombo.getValue();
        String type = typeFlightCombo.getValue();
        String passport = passportField.getText();

        formHasErrors = false;
        validateFields(flight, passport, type);

        if (formHasErrors) {
            showWarningMessage("Warning", "The form present several errors.\nCheck the error log panel.");
            return;
        }

        TicketDTO ticket = new TicketDTO();
        ticket.setDateOfTravel(datePicker.getValue());
        ticket.setFlightCode(flight.getFlightCode());
        ticket.setPassportno(passport);

        ticketService.createNewTicket(event, ticket, passport);
    }

    private void validateFields(FlightEntity flight, String passport, String type) {
        checkServerStatus();
        if(formHasErrors)
            return;

        if (flight == null) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "Flight field must be completed.";
            formHasErrors = true;
            return;
        }

        if (type == null) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "Flight-VIP field must be completed.";
            formHasErrors = true;
            return;
        }

        if (passport == null || passport.isEmpty()) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "Passport field must be completed.";
            formHasErrors = true;
            return;
        }

        if (!passport.matches("^[A-Z][0-9]{7}$")) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "Passport format is not valid.";
            formHasErrors = true;
            return;
        }

        boolean availableSeats = isAvailableSeats();
        if (!availableSeats) {
            errorMessage = "There are no available seats.";
            formHasErrors = true;
            return;
        }

        boolean duplicatedTicket = isDuplicatedTicket();
        if (duplicatedTicket) {
            errorMessage = "There is a ticket for that day already.";
            formHasErrors = true;
            return;
        }
    }

    private boolean isAvailableSeats() {
        String flightCode = flightCombo.getValue().getFlightCode();
        LocalDate flightDate = datePicker.getValue();
        return ticketService.getAvailableSeats(flightCode, flightDate);
    }

    private boolean isDuplicatedTicket() {
        String passportno = passportField.getText();
        LocalDate flightDate = datePicker.getValue();
        return ticketService.getDuplicatedFlight(passportno, flightDate);
    }

    public void checkServerStatus() {
        boolean status = ticketService.checkServerStatus();
        if (!status) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "The application is not connected to the server.";
            formHasErrors = true;
        } else {
            formHasErrors = false;
            errorMessage = null;
        }
    }


    public void showErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Please, check these form errors");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    private void showWarningMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean isFormHasErrors() {
        return formHasErrors;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}


