package andres.flights_v2.Controllers;

import andres.flights_v2.controllers.FlightsController;
import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightsControllerTest {

    // TODO Debo hacer otra prueba para el servicio mockeando el controlador?
    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightsController flightsController;

    private AirportEntity origin;
    private AirportEntity destination;

    @BeforeEach
    void setUp() {
        // TODO Debo introducir los valores reales de la aplicacion
        // o solo valores de prueba?
        origin = new AirportEntity();
        origin.setCode("MAD");
        origin.setName("Madrid");

        destination = new AirportEntity();
        destination.setCode("BCN");
        destination.setName("Barcelona");
    }

    // TODO Cada test debe ser lo mas unitario posible?
    // Es posible reducir aun mas el codigo de la funcion unitaria?
    @Test
    void testFindAllFlights() {
        // TODO Codigo que no se entiende? O codigo con formato exagerado?
        List<AirportEntity> mockOrigins = Arrays.asList(origin);
        when(flightService.findAllOrigins()).thenReturn(mockOrigins);

        List<AirportEntity> result = flightsController.findAllFlights();

        // TODO valores esperados por la aplicacion o solo valores de prueba?
        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0).getName());
        verify(flightService, times(1)).findAllOrigins();

        // TODO mensajes por consola son posibles?
        System.out.println("mensaje por consola de test");
    }

    @Test
    void testFindDestinationsByOrigin() {
        List<AirportEntity> mockDestinations = Arrays.asList(destination);
        when(flightService.findDestinationsByOrigin("MAD")).thenReturn(mockDestinations);

        List<AirportEntity> result = flightsController.findDestinationsByOrigin("MAD");

        assertEquals(1, result.size());
        assertEquals("Barcelona", result.get(0).getName());
        verify(flightService, times(1)).findDestinationsByOrigin("MAD");
    }

    @Test
    void testFindFlightCodeByRoute() {
        List<String> mockCodes = List.of("FL123", "FL456");
        when(flightService.findFlightCodeByRoute("MAD", "BCN")).thenReturn(mockCodes);

        List<String> result = flightsController.findFlightCodeByRoute("MAD", "BCN");

        assertEquals(2, result.size());
        assertTrue(result.contains("FL123"));
        verify(flightService, times(1)).findFlightCodeByRoute("MAD", "BCN");
    }

    // TODO Añadir mas test con resultados inesperados?
    // Cual es la gracia de los test, comprobar que funciona bien, comprobar TODOS los
    // Resultados inesperados? Que espera el profesor de nosotros?
    // Cuantos mas test y de mejor calidad mayor porcentaje de codigo cubierto funcional?
}
