package andres.flights_jfxtemplate.Service;

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

public class TicketService {

    public void createNewTicket(ActionEvent event, TicketDTO ticket) {
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
                System.out.println("respuesta falsa");
            } else {
                System.out.println("Respuesta inesperada del servidor: " + responseBody);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
