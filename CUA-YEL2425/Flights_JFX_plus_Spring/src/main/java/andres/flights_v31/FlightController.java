package andres.flights_v31;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;

public class FlightController {

    @FXML
    private ComboBox<String> cityComboBox;

//    private final IAirportDAO airportDAO;
//
//    @Autowired
//    public FlightController() {
//        this.airportDAO = SpringContext.getBean(IAirportDAO.class);
//    }

//    @FXML
//    public void initialize() {
//        // Cargar aeropuertos en el hilo de JavaFX
//        Platform.runLater(() -> {
//            for (AirportEntity airport : airportDAO.findAll()) {
//                cityComboBox.getItems().add(airport.getName());
//            }
//        });
//    }
}
