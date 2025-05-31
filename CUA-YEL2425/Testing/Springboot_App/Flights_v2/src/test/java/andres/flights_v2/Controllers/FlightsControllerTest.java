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

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightsController flightsController;

    private AirportEntity origin;
    private AirportEntity destination;

    @BeforeEach
    void setUp() {
        origin = new AirportEntity();
        origin.setCode("MAD");
        origin.setName("Madrid");

        destination = new AirportEntity();
        destination.setCode("BCN");
        destination.setName("Barcelona");
    }

    @Test
    void testFindAllFlights() {
        List<AirportEntity> mockOrigins = Arrays.asList(origin);
        when(flightService.findAllOrigins()).thenReturn(mockOrigins);

        List<AirportEntity> result = flightsController.findAllFlights();

        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0).getName());
        verify(flightService, times(1)).findAllOrigins();

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
}
