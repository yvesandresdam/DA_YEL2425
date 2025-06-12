package andres.flights_jfxtemplate.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import andres.flights_jfxtemplate.DTO.TicketDTO;
import andres.flights_jfxtemplate.Entity.AirportEntity;
import andres.flights_jfxtemplate.Entity.FlightEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FlightService {

    public List<AirportEntity> getAllOrigins() {
        List<AirportEntity> airportEntities = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Flights/Origins"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONArray jsonArray = new JSONArray(response.body());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject airportJson = jsonArray.getJSONObject(i);
                    String code = airportJson.getString("code");
                    String name = airportJson.getString("name");

                    airportEntities.add(new AirportEntity(code, name));
                }
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return airportEntities;
    }

    public List<AirportEntity> getDestinationsByOrigin(String originId) {
        List<AirportEntity> destinations = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Flights/Destinations/" + originId))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONArray jsonArray = new JSONArray(response.body());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    String code = json.getString("code");
                    String name = json.getString("name");
                    destinations.add(new AirportEntity(code, name));
                }
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return destinations;
    }

    public List<FlightEntity> getAllFlights(String originId, String destinationId) {
        List<FlightEntity> flightEntities = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Flights/" + originId + "/" + destinationId))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONArray jsonArray = new JSONArray(response.body());

                for (int i = 0; i < jsonArray.length(); i++) {
                    String code = jsonArray.getString(i);
                    flightEntities.add(new FlightEntity(code));
                }
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flightEntities;
    }
}

