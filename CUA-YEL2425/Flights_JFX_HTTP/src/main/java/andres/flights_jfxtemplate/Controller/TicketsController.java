package andres.flights_jfxtemplate.Controller;

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
    private ComboBox<AirportEntity> originCombo;
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
    private Label logLabel;

    private String errorMessage;
    private boolean formHasErrors;

    private FlightService flightService = new FlightService();
    private TicketService ticketService = new TicketService();

    @FXML
    public void initialize() {
        checkServerStatus();

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

    private void loadOrigins() {
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
            Parent nuevaVista = FXMLLoader.load(getClass().getResource("/andres/flights_jfxtemplate/nvg-passenger-creation.fxml"));
            Scene nuevaEscena = new Scene(nuevaVista);

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

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
        System.out.println("error");

        formHasErrors = false;

        if (flight == null || type == null || passport == null || passport.isEmpty()) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "Faltan datos en el formulario";
            formHasErrors = true;
            return;
        }

        if (!passport.matches("^[A-Z][0-9]{7}$")) {
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "Formato de pasaporte incorrecto";
            System.out.println("Formato de pasaporte inválido. Debe ser una letra seguida de 7 números (ej: A1234567).");
            formHasErrors = true;
            return;
        }

        boolean availableSeats = isAvailableSeats();
        if (!availableSeats) {
            showWarningMessage("Atencion", "No quedan asientos disponibles");
            formHasErrors = true;
            return;
        }

        boolean duplicatedTicket = isDuplicatedTicket();
        if (duplicatedTicket) {
            showWarningMessage("Atencion", "Ya existe un ticket para esa fecha");
            formHasErrors = true;
            return;
        }

        TicketDTO ticket = new TicketDTO();
        ticket.setDateOfTravel(datePicker.getValue());
        ticket.setFlightCode(flight.getFlightCode());
        ticket.setPassportno(passport);
        System.out.println(ticket.getPassportno());

        if(formHasErrors){
            showWarningMessage("Error", "Revise el log de errores");
        }

        ticketService.createNewTicket(event, ticket, passport);
    }

    public void showErrorLog(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("El formulario contiene errores");
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

    private void checkServerStatus(){
        boolean status = ticketService.checkServerStatus();
        if(!status){
            logLabel.setStyle("-fx-background-color: red;");
            errorMessage = "La aplicacion no esta conectada";
            formHasErrors = true;
        } else{
            formHasErrors = false;
        }
    }
}

