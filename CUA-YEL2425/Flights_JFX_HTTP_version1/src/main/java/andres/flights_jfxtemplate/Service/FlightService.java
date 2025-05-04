package andres.flights_jfxtemplate.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import andres.flights_jfxtemplate.Entity.AirportEntity;
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
}
