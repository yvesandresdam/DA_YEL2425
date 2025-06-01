package andres.flights_jfxtemplate.Bridges;

import andres.flights_jfxtemplate.Controller.PassengerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Ticket_in_Passenger {
    @FXML
    Button buttonNextScreen;
    @FXML
    Button buttonPreviousScreen;
    String passportno;
    public void loadPassengerScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/view-passenger-form.fxml"));
        Scene scene = new Scene(loader.load());

        PassengerController controller = loader.getController();
        controller.setPassportField(passportno);

        Stage stage = (Stage) buttonNextScreen.getScene().getWindow();
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void loadTicketScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/andres/flights_jfxtemplate/view-ticket-form.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) buttonNextScreen.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setPassportno(String passportForm){
        passportno = passportForm;
    }
}
