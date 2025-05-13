package andres.flights_jfxtemplate.Controller;

import andres.flights_jfxtemplate.Service.PassengerService;
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

    private PassengerService passengerService = new PassengerService();

    @FXML
    public void initialize() {
        genderCombo.getItems().addAll("M", "F");
    }

    @FXML
    private void createNewUser() {
        PassengerDTO passenger = new PassengerDTO();
        passenger.setFirstname(nameField.getText());
        passenger.setLastname(lastNameField.getText());
        passenger.setPassportno(passportField.getText());
        passenger.setAddress(addressField.getText());
        passenger.setPhone(phoneField.getText());
        passenger.setSex(genderCombo.getValue());

        passengerService.createNewPassenger(passenger);

        buttonCreateNewPassengerAction();
    }

    @FXML
    private void buttonCreateNewPassengerAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/msg-passenger-success.fxml"));
            Scene newScene = new Scene(loader.load());

            Stage stage = (Stage) buttonNewUser.getScene().getWindow();

            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

