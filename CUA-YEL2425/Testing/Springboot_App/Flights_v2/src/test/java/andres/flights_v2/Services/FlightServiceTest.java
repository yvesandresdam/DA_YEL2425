package andres.flights_v2.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private IFlightsEntityDAO flightDAO;

    @InjectMocks
    private FlightService flightService;


    // TESTS
    // FIND ALL ORIGINS
    @Test
    public void testFindAllOrigins() {
        AirportEntity airport1 = new AirportEntity("LIA", "Louisville International Airport");
        AirportEntity airport2 = new AirportEntity("CHIA", "Chandigarh International Airport");
        AirportEntity airport3 = new AirportEntity("DFWI", "Dallas/Fort Worth International Airport");
        AirportEntity airport4 = new AirportEntity("IGIA", "Indira GandhiInternational Airport");
        AirportEntity airport5 = new AirportEntity("CSIA", "Chhatrapati Shivaji International Airport");
        AirportEntity airport6 = new AirportEntity("SFIA", "San Francisco International Airport");
        AirportEntity airport7 = new AirportEntity("FKFI", "Frankfurt Airport");
        AirportEntity airport8 = new AirportEntity("GBIA", "George Bush Intercontinental Airport");
        AirportEntity airport9 = new AirportEntity("JFKI", "John F. Kennedy International Airport");
        AirportEntity airport10 = new AirportEntity("TIA", "Tampa International Airport");

        List<AirportEntity> mockOrigins = Arrays.asList(airport1, airport2, airport3, airport4, airport5, airport6, airport7, airport8, airport9, airport10);

        when(flightDAO.findAllOrigins()).thenReturn(mockOrigins);

        List<AirportEntity> result = flightService.findAllOrigins();
        assertEquals(10, result.size());

        assertEquals("LIA", result.get(0).getCode());
        assertEquals("Louisville International Airport", result.get(0).getName());

        assertEquals("CHIA", result.get(1).getCode());
        assertEquals("Chandigarh International Airport", result.get(1).getName());

        assertEquals("DFWI", result.get(2).getCode());
        assertEquals("Dallas/Fort Worth International Airport", result.get(2).getName());

        assertEquals("IGIA", result.get(3).getCode());
        assertEquals("Indira GandhiInternational Airport", result.get(3).getName());

        assertEquals("CSIA", result.get(4).getCode());
        assertEquals("Chhatrapati Shivaji International Airport", result.get(4).getName());

        assertEquals("SFIA", result.get(5).getCode());
        assertEquals("San Francisco International Airport", result.get(5).getName());

        assertEquals("FKFI", result.get(6).getCode());
        assertEquals("Frankfurt Airport", result.get(6).getName());

        assertEquals("GBIA", result.get(7).getCode());
        assertEquals("George Bush Intercontinental Airport", result.get(7).getName());

        assertEquals("JFKI", result.get(8).getCode());
        assertEquals("John F. Kennedy International Airport", result.get(8).getName());

        assertEquals("TIA", result.get(9).getCode());
        assertEquals("Tampa International Airport", result.get(9).getName());
    }

    // TESTS
    // FIND DESTINATIONS
    // BY ORIGIN
    @Test
    public void testFindDestinationsByOrigin_CSIA() {
        String originCode = "CSIA";
        AirportEntity destination1 = new AirportEntity("DFWI", "Dallas/Fort Worth International Airport");
        AirportEntity destination2 = new AirportEntity("SFIA", "San Francisco International Airport");

        when(flightDAO.findDestinationsByOrigin(originCode)).thenReturn(List.of(destination1, destination2));

        List<AirportEntity> result = flightService.findDestinationsByOrigin(originCode);
        assertEquals(2, result.size());
        assertEquals("DFWI", result.get(0).getCode());
        assertEquals("Dallas/Fort Worth International Airport", result.get(0).getName());
        assertEquals("SFIA", result.get(1).getCode());
        assertEquals("San Francisco International Airport", result.get(1).getName());
    }

    @Test
    public void testFindDestinationsByOrigin_JFKI() {
        String originCode = "JFKI";
        AirportEntity destination1 = new AirportEntity("TIA", "Tampa International Airport");
        AirportEntity destination2 = new AirportEntity("CSIA", "Chhatrapati Shivaji International Airport");

        when(flightDAO.findDestinationsByOrigin(originCode)).thenReturn(List.of(destination1, destination2));

        List<AirportEntity> result = flightService.findDestinationsByOrigin(originCode);
        assertEquals(2, result.size());
        assertEquals("TIA", result.get(0).getCode());
        assertEquals("Tampa International Airport", result.get(0).getName());
        assertEquals("CSIA", result.get(1).getCode());
        assertEquals("Chhatrapati Shivaji International Airport", result.get(1).getName());
    }

    @Test
    public void testFindDestinationsByOrigin_LIA() {
        String originCode = "LIA";
        AirportEntity destination1 = new AirportEntity("GBIA", "George Bush Intercontinental Airport");

        when(flightDAO.findDestinationsByOrigin(originCode)).thenReturn(List.of(destination1));

        List<AirportEntity> result = flightService.findDestinationsByOrigin(originCode);
        assertEquals(1, result.size());
        assertEquals("GBIA", result.get(0).getCode());
        assertEquals("George Bush Intercontinental Airport", result.get(0).getName());
    }

    @Test
    public void testFindDestinationsByOrigin_GBIA() {
        String originCode = "GBIA";
        AirportEntity destination1 = new AirportEntity("IGIA", "Indira GandhiInternational Airport");

        when(flightDAO.findDestinationsByOrigin(originCode)).thenReturn(List.of(destination1));

        List<AirportEntity> result = flightService.findDestinationsByOrigin(originCode);
        assertEquals(1, result.size());
        assertEquals("IGIA", result.get(0).getCode());
        assertEquals("Indira GandhiInternational Airport", result.get(0).getName());
    }

    @Test
    public void testFindDestinationsByOrigin_SFIA() {
        String originCode = "GBIA";
        AirportEntity destination1 = new AirportEntity("SFIA", "San Francisco International Airport");

        when(flightDAO.findDestinationsByOrigin(originCode)).thenReturn(List.of(destination1));

        List<AirportEntity> result = flightService.findDestinationsByOrigin(originCode);
        assertEquals(1, result.size());
        assertEquals("SFIA", result.get(0).getCode());
        assertEquals("San Francisco International Airport", result.get(0).getName());
    }

    @Test
    public void testFindDestinationsByOrigin_FKFI() {
        String originCode = "GBIA";
        AirportEntity destination1 = new AirportEntity("FKFI", "Frankfurt Airport");

        when(flightDAO.findDestinationsByOrigin(originCode)).thenReturn(List.of(destination1));

        List<AirportEntity> result = flightService.findDestinationsByOrigin(originCode);
        assertEquals(1, result.size());
        assertEquals("FKFI", result.get(0).getCode());
        assertEquals("Frankfurt Airport", result.get(0).getName());
    }

    // TESTS
    // FIND FLIGHTCODE
    // BY ORIGIN-DESTINATION
    @Test
    public void testFindFlightCodeByRoute_LIA() {
        String origin = "LIA";
        String destination = "GBIA";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("QR1902"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("QR1902", result.get(0));
    }

    @Test
    public void testFindFlightCodeByRoute_GBIA() {
        String origin = "GBIA";
        String destination = "IGIA";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("9W2334"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("9W2334", result.get(0));
    }

    @Test
    public void testFindFlightCodeByRoute_CSIA() {
        String origin = "CSIA";
        String destination = "DFWI";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("QR2305", "BA3056", "AI2014"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(3, result.size());
        assertEquals("QR2305", result.get(0));
        assertEquals("BA3056", result.get(1));
        assertEquals("AI2014", result.get(2));
    }

    @Test
    public void testFindFlightCodeByRoute_JFKI() {
        String origin = "JFKI";
        String destination = "TIA";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("EY1234"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("EY1234", result.get(0));
    }

    @Test
    public void testFindFlightCodeByRoute_JFKI_2() {
        String origin = "JFKI";
        String destination = "CSIA";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("LH9876"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("LH9876", result.get(0));
    }

    @Test
    public void testFindFlightCodeByRoute_CSIA_2() {
        String origin = "CSIA";
        String destination = "SFIA";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("EK3456"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("EK3456", result.get(0));
    }

    @Test
    public void testFindFlightCodeByRoute_SFIA() {
        String origin = "SFIA";
        String destination = "FKFI";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("AA4367"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("AA4367", result.get(0));
    }

    @Test
    public void testFindFlightCodeByRoute_FKFI() {
        String origin = "FKFI";
        String destination = "IGIA";

        when(flightDAO.findFlightCodeByRoute(origin, destination)).thenReturn(List.of("BA1689"));

        List<String> result = flightService.findFlightCodeByRoute(origin, destination);
        assertEquals(1, result.size());
        assertEquals("BA1689", result.get(0));
    }
}
