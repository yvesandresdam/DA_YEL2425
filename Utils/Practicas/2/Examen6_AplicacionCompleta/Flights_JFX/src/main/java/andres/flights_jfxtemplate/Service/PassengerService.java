package andres.flights_jfxtemplate.Service;

import andres.flights_jfxtemplate.DTO.PassengerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PassengerService {
    public void createNewPassenger(PassengerDTO passenger) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(passenger);

            URL url = new URL("http://localhost:8080/flights_api/Passenger/CreateNewPassenger");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Passenger created successfully");
            } else {
                System.err.println("Error: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDuplicatedPassport(String passportno) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/flights_api/Passenger/Passport/" + passportno))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return (response.equals("true"));
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
