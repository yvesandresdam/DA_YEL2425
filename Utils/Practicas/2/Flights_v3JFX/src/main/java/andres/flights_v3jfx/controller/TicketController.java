package andres.flights_v3jfx.controller;

import andres.flights_v3jfx.service.FlightService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class TicketController {
    @FXML
    private ComboBox<String> comboOrigins;

    private FlightService flightService = new FlightService();

    private void loadOrigins() {
        comboOrigins.getItems().addAll(flightService.getAllOrigins());
    }

    @FXML
    public void initialize(){
        loadOrigins();
    }


}