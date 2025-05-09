package andres.flights_jfxtemplate.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import andres.flights_jfxtemplate.DTO.PassengerDTO;
import javafx.stage.Stage;
import org.json.JSONObject;

public class PassengerController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField passportField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private ComboBox<String> genderCombo;
    @FXML
    private Button buttonNewUser;

    @FXML
    public void initialize() {
        genderCombo.getItems().addAll("M", "F");
    }

    @FXML
    private void createNewUser() {
        try {
            PassengerDTO passenger = new PassengerDTO();
            passenger.setFirstname(nameField.getText());
            passenger.setLastname(lastNameField.getText());
            passenger.setPassportno(passportField.getText());
            passenger.setAddress(addressField.getText());
            passenger.setPhone(phoneField.getText());
            passenger.setSex(genderCombo.getValue());

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

        buttonCreateNewPassengerAction();
    }

    @FXML
    private void buttonCreateNewPassengerAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/success-page.fxml"));
            Scene newScene = new Scene(loader.load());

            Stage stage = (Stage) buttonNewUser.getScene().getWindow();

            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
