package andres.flights_jfxtemplate.Controller;

import andres.flights_jfxtemplate.Service.PassengerService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

import andres.flights_jfxtemplate.DTO.PassengerDTO;
import javafx.stage.Stage;

public class PassengerController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Label passportField;
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

    public void setPassportField(String passportno) {
        passportField.setText(passportno);
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

        if (!passenger.getPassportno().matches("^[A-Z][0-9]{7}$")) {
            showWarningMessage("Entrada inválida", "El pasaporte tiene un formato incorrecto");
            return;
        }

        if (!passenger.getPhone().matches("^\\+34[0-9]{9}$")) {
            showWarningMessage("Entrada inválida", "El numero movil tiene un formato incorrecto");
            return;
        }

        if (passenger.getFirstname().isEmpty()) {
            showWarningMessage("Entrada inválida", "El nombre no debe estar en blanco");
            return;
        }

        boolean duplicatedPassport = validateDuplicatedPassport(passenger.getPassportno());
        if (duplicatedPassport) {
            showWarningMessage("Entrada inválida", "El pasaporte ya existe en la base de datos");
            return;
        }

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

    private boolean validateDuplicatedPassport(String passportno){
        return passengerService.isDuplicatedPassport(passportno);
    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showWarningMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInformationMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

