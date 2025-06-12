package andres.flights_jfxtemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TicketsController {

    @FXML
    private ComboBox<Integer> dayComboBox;
    @FXML
    private ComboBox<Integer> monthComboBox;
    @FXML
    private ComboBox<Integer> yearComboBox;
    @FXML
    private ComboBox<String> originComboBox;
    @FXML
    private ComboBox<String> destinationComboBox;
    @FXML
    private ComboBox<String> flightComboBox;
    @FXML
    private ComboBox<String> flightPictoComboBox;
    @FXML
    private TextField passportField;
    @FXML
    private Button flightCreateButton;
    @FXML
    private Button buyTicketButton;

    private final String URL = "jdbc:postgresql://localhost:5432/Flights";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public void initialize() {
        populateDays();
        populateMonths();
        populateYears();
        populateOrigins();
        populatePicto();
        setupOriginListener();
        setupDestinationListener();
    }

    private void populateDays() {
        for (int i = 1; i <= 31; i++) {
            dayComboBox.getItems().add(i);
        }
    }

    private void populateMonths() {
        for (int i = 1; i <= 12; i++) {
            monthComboBox.getItems().add(i);
        }
    }

    private void populateYears() {
        for (int i = 2025; i <= 2030; i++) {
            yearComboBox.getItems().add(i);
        }
    }

    private void populateOrigins() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM airports")) {

            while (rs.next()) {
                originComboBox.getItems().add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populatePicto() {
        flightPictoComboBox.getItems().add("♪");
        flightPictoComboBox.getItems().add("⏱");
        flightPictoComboBox.getItems().add("✈");
    }

    private void setupOriginListener() {
        originComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadDestinations(newValue);
            }
        });
    }

    private void loadDestinations(String selectedOrigin) {
        destinationComboBox.getItems().clear();

        //String query = "SELECT destination FROM flights WHERE source = ?";

        String query = "SELECT a.name " +
                "FROM flights f " +
                "JOIN airports a ON f.destination = a.code " +
                "WHERE f.source = (SELECT code FROM airports WHERE name = ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedOrigin);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String destination = rs.getString("name");
                destinationComboBox.getItems().add(destination);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupDestinationListener() {
        destinationComboBox.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && originComboBox.getValue() != null) {
                loadFlights(originComboBox.getValue(), newValue);
            }
        });
    }

    private void loadFlights(String selectedOrigin, String selectedDestination) {
        flightComboBox.getItems().clear();

        String query = "SELECT flight_code " +
                "FROM flights " +
                "WHERE source = (SELECT code FROM airports WHERE name = ?) " +
                "AND destination = (SELECT code FROM airports WHERE name = ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedOrigin);
            stmt.setString(2, selectedDestination);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String flightCode = rs.getString("flight_code");
                flightComboBox.getItems().add(flightCode);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/passenger-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) flightCreateButton.getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBuyTicketButtonAction(ActionEvent event) {
        Integer day = dayComboBox.getValue();
        Integer month = monthComboBox.getValue();
        Integer year = yearComboBox.getValue();
        String origin = originComboBox.getValue();
        String destination = destinationComboBox.getValue();
        String flightCode = flightComboBox.getValue();
        String passport = passportField.getText();

        if (day == null || month == null || year == null || origin == null || destination == null || flightCode == null || passport.isEmpty()) {
            System.out.println("Por favor, completa todos los campos.");
            return;
        }

        String sql = "INSERT INTO tickets (passportno, flight_code, date_of_travel, date_of_booking) VALUES (?, ?, ?, ?)";
        String fullDate = String.format("%04d-%02d-%02d", year, month, day);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, passport);
            pstmt.setString(2, flightCode);
            pstmt.setDate(3, Date.valueOf(fullDate));
            pstmt.setDate(4,Date.valueOf(LocalDate.now()));

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Ticket comprado correctamente.");
            } else {
                System.out.println("No se pudo comprar el ticket.");
            }

        } catch (SQLException e) {
            System.out.println("Error al comprar el ticket: " + e.getMessage());
        }
    }
}

