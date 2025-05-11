package andres.flights_jfxtemplate.Bridges;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Ticket_in_Passenger {
    @FXML
    Button buttonNextScreen;
    public void loadNextScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/view-passenger-form.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) buttonNextScreen.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void loadTicketScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/view-ticket-form.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) buttonNextScreen.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
