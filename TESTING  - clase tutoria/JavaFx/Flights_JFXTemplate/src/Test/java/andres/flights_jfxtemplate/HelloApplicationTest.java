package andres.flights_jfxtemplate;// JUnit 5
import andres.flights_jfxtemplate.Entity.AirportEntity;
import andres.flights_jfxtemplate.Service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class HelloApplicationTest {

    Button button;
    Label label;

    @BeforeEach
    public void setup() {
        button = new Button("Click me!");
        label = new Label("Not clicked");
        button.setOnAction(e -> label.setText("Clicked!"));
    }

    @Test
    public void testButtonActionDirectly() {
        // Simula el clic llamando directamente al handler
        button.fire();

        // Verifica que el texto del label cambió
        assertEquals("Clicked!", label.getText());
    }

    @Test
    public void testGetAllOrigins() {
        // Instancia la clase que contiene getAllOrigins (ajusta el nombre según tu código)
        FlightService service = new FlightService();

        List<AirportEntity> expected = Arrays.asList(
                new AirportEntity("CSIA", "Chhatrapati Shivaji International Airport"),
                new AirportEntity("JFKI", "John F. Kennedy International Airport"),
                new AirportEntity("FKFI", "Frankfurt Airport"),
                new AirportEntity("LIA", "Louisville International Airport"),
                new AirportEntity("SFIA", "San Francisco International Airport"),
                new AirportEntity("GBIA", "George Bush Intercontinental Airport")
        );

        List<AirportEntity> actual = service.getAllOrigins();

        assertEquals(expected, actual);
    }
}