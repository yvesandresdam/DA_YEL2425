package andres.flights_jfxtemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
    private ComboBox<String> genderComboBox;

    @FXML
    private Button createUserButton;

    @FXML
    public void initialize() {
        genderComboBox.getItems().addAll("M", "F");
    }

    @FXML
    private void handleCreateUserButtonAction() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String passport = passportField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String gender = genderComboBox.getValue();

        if (name.isEmpty() || lastName.isEmpty() || passport.isEmpty() || address.isEmpty() || phone.isEmpty() || gender == null) {
            System.out.println("Por favor, rellena todos los campos.");
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/Flights";
        String user = "postgres";
        String passwordDB = "postgres";

        String sql = "INSERT INTO passengers (firstname, lastname, passportno, address, phone, sex) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setString(3, passport);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setString(6, gender);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pasajero creado correctamente.");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/tickets-view.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) createUserButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                System.out.println("No se pudo crear el pasajero.");
            }

        } catch (SQLException | IOException e) {
            System.out.println("Error al insertar el pasajero: " + e.getMessage());
        }
    }

//    @FXML
//    private void handleCreatePassengerButtonAction(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/tickets-view.fxml"));
//            Parent root = loader.load();
//
//            Stage stage = (Stage) createUserButton.getScene().getWindow();
//
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
