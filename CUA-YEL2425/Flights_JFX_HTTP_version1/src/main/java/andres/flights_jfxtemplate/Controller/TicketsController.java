package andres.flights_jfxtemplate.Controller;

import andres.flights_jfxtemplate.Entity.AirportEntity;
import andres.flights_jfxtemplate.Service.FlightService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class TicketsController {

    @FXML
    private ComboBox<AirportEntity> originCombo;

    private FlightService flightService = new FlightService();

    @FXML
    public void initialize() {
        loadOrigins();
    }

    public void loadOrigins() {
        originCombo.getItems().clear();
        originCombo.getItems().addAll(flightService.getAllOrigins());
    }
}