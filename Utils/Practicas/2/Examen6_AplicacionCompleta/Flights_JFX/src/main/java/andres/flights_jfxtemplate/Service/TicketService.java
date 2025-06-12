package andres.flights_jfxtemplate.Service;

import andres.flights_jfxtemplate.Bridges.Ticket_in_Passenger;
import andres.flights_jfxtemplate.Controller.PassengerController;
import andres.flights_jfxtemplate.DTO.TicketDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class TicketService {

    public void createNewTicket(ActionEvent event, TicketDTO ticket, String passportno) {
        try {
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/nvg-passenger-creation.fxml"));
                Parent nuevaVista = loader.load();

                Ticket_in_Passenger controller = loader.getController();
                controller.setPassportno(passportno);

                Scene nuevaEscena = new Scene(nuevaVista);
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.setScene(nuevaEscena);
                stage.show();
            } else {
                System.out.println("Respuesta inesperada del servidor: " + responseBody);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean getAvailableSeats(String flightCode, LocalDate flightDate) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Flights/Available/" + flightCode + "/" + flightDate))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return (response.body().equals("true"));
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getDuplicatedFlight(String passportno, LocalDate flightDate){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Tickets/Available/" + flightDate + "/" + passportno))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return (response.body().equals("true"));
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkServerStatus() {
        String url = "http://localhost:8080/flights_api";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 || response.statusCode() == 302) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


