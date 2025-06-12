package andres.flights_v3jfx.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    public List<String> getAllOrigins() {
        List<String> origins = new ArrayList<>();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/flights/all"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JSONArray jsonArray = new JSONArray(response.body());
                for (int i = 0; i < jsonArray.length(); i++) {
                    /*
                    JSONObject airportJson = jsonArray.getJSONObject(i);
                    String code = airportJson.getString("code");
                    String name = airportJson.getString("name");
                    airportEntities.add(new AirportEntity(code, name));
                     */
                    String airportJson = jsonArray.getString(i);
                    origins.add(airportJson);
                }
            } else {
                throw new RuntimeException("Error - condicion else de respuesta");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error - catch de carga de todos los origenes");
        }
        return origins;
    }
}
