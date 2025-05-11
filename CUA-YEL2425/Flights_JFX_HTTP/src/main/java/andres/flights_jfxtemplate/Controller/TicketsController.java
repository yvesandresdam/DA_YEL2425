package andres.flights_jfxtemplate.Controller;

import andres.flights_jfxtemplate.DTO.TicketDTO;
import andres.flights_jfxtemplate.Entity.AirportEntity;
import andres.flights_jfxtemplate.Entity.FlightEntity;
import andres.flights_jfxtemplate.Service.FlightService;
import andres.flights_jfxtemplate.Service.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;

public class TicketsController {
    @FXML
    private ComboBox<Integer> dayCombo;
    @FXML
    private ComboBox<Integer> monthCombo;
    @FXML
    private ComboBox<Integer> yearCombo;
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

    private FlightService flightService = new FlightService();
    private TicketService ticketService = new TicketService();

    @FXML
    public void initialize() {
        loadDate();
        loadOrigins();
        loadTypeFlight();
        listenerOrigins();
        listenerDestination();
        listenerTypeFlights();
    }

    private void loadDate() {
        for (int i = 1; i <= 31; i++) {
            dayCombo.getItems().add(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthCombo.getItems().add(i);
        }
        for (int i = 2025; i <= 2030; i++) {
            yearCombo.getItems().add(i);
        }
    }

    private void loadOrigins() {
        originCombo.getItems().addAll(flightService.getAllOrigins());
    }

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
        Integer day = dayCombo.getValue();
        Integer month = monthCombo.getValue();
        Integer year = yearCombo.getValue();
        FlightEntity flight = flightCombo.getValue();
        String type = typeFlightCombo.getValue();
        String passport = passportField.getText();

        if (day == null || month == null || year == null || flight == null || type == null || passport == null || passport.isEmpty()) {
            System.out.println("Faltan datos del formulario.");
            return;
        }

        TicketDTO ticket = new TicketDTO();
        ticket.setDateOfTravel(LocalDate.of(year, month, day));
        ticket.setFlightCode(flight.getFlightCode());
        ticket.setPassportno(passport);

        ticketService.createNewTicket(event, ticket);
    }
}

/*
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            String json = mapper.writeValueAsString(ticket);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Tickets/CreateTicket"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body().trim();

            if ("true".equals(response.body())) {
                Parent nuevaVista = FXMLLoader.load(getClass().getResource("/andres/flights_jfxtemplate/msg_ticket_success.fxml"));
                Scene nuevaEscena = new Scene(nuevaVista);

                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();

                stage.setScene(nuevaEscena);
                stage.show();
            } else if ("false".equalsIgnoreCase(responseBody)) {
                System.out.println("respuesta falsa");
            } else {
                System.out.println("Respuesta inesperada del servidor: " + responseBody);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

             */