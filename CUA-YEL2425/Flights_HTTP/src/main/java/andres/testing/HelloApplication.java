package andres.testing;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelloApplication extends Application {

    private ComboBox<String> comboBox = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(comboBox);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Aeropuertos");
        primaryStage.setScene(scene);
        primaryStage.show();

        loadAirportNames();
    }

    private void loadAirportNames() {
        Task<List<String>> task = new Task<>() {
            @Override
            protected List<String> call() throws Exception {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/flights_api/Flights/Origins"))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response.body());

                // Suponiendo que es una lista de objetos tipo { "code": "...", "name": "..." }
                return root.findValues("name").stream()
                        .map(JsonNode::asText)
                        .collect(Collectors.toList());
            }
        };

        task.setOnSucceeded(e -> comboBox.getItems().setAll(task.getValue()));
        task.setOnFailed(e -> task.getException().printStackTrace());

        new Thread(task).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}