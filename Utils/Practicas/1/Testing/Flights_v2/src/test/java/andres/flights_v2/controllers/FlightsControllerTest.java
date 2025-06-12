package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
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

    private AirportEntity origin1;
    private AirportEntity destination1;

    @BeforeEach
    void setUp() {
        origin1 = new AirportEntity();
        origin1.setCode("MAD");
        origin1.setName("Madrid");

        destination1 = new AirportEntity();
        destination1.setCode("BCN");
        destination1.setName("Barcelona");
    }

    @Test
    void testFindAllFlights() {
        List<AirportEntity> mockOrigins = Arrays.asList(origin1);
        when(flightService.findAllOrigins()).thenReturn(mockOrigins);

        List<AirportEntity> result = flightsController.findAllFlights();

        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0).getName());
        verify(flightService, times(1)).findAllOrigins();
    }

    @Test
    void testFindDestinationsByOrigin() {
        List<AirportEntity> mockDestinations = Arrays.asList(destination1);
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

    @Test
    void testCheckSeatAvailability() {
        LocalDate flightDate = LocalDate.of(2025, 6, 10);
        when(flightService.areSeatsAvailable("FL123", flightDate)).thenReturn(true);

        Boolean available = flightsController.checkSeatAvailability("FL123", flightDate);

        assertTrue(available);
        verify(flightService, times(1)).areSeatsAvailable("FL123", flightDate);
    }
}

