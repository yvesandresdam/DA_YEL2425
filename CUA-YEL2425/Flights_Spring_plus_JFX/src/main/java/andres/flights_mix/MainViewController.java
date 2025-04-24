package andres.flights_mix;

import andres.flights_mix.Models.AirportEntity;
import andres.flights_mix.Service.AirportService;
import jakarta.annotation.PostConstruct;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainViewController {

    @FXML
    private ComboBox<String> airportCombo;

    private final AirportService airportService;

    public MainViewController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostConstruct
    public void init() {
        List<String> airports = airportService.findAllNames();
        for (String airport : airports) {
            airportCombo.getItems().add(airport);
        }
    }
}

