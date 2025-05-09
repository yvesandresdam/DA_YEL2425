package andres.flights_jfxtemplate.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TransitionController {
    @FXML
    Button buttonNextScreen;
    public void loadNextScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/passenger-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) buttonNextScreen.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void loadTicketScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/ticket-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) buttonNextScreen.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
