package andres.andresflights_jfxtemplate.Controller;

import andres.flights_jfxtemplate.Entity.AirportEntity;
import andres.flights_jfxtemplate.Service.FlightService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketsControllerTest {

    private FlightService flightService = new FlightService();

    @Test
    public void testGetAllOrigins() {
        String jsonResponse =
                "[{\"code\":\"CSIA\",\"name\":\"Chhatrapati Shivaji International Airport\"}," +
                "{\"code\":\"JFKI\",\"name\":\"John F. Kennedy International Airport\"}," +
                "{\"code\":\"FKFI\",\"name\":\"Frankfurt Airport\"}," +
                "{\"code\":\"LIA\",\"name\":\"Louisville International Airport\"}," +
                "{\"code\":\"SFIA\",\"name\":\"San Francisco International Airport\"}," +
                "{\"code\":\"GBIA\",\"name\":\"George Bush Intercontinental Airport\"}]";

        List<AirportEntity> origins = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonResponse);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            origins.add(new AirportEntity(obj.getString("code"), obj.getString("name")));
        }

        assertEquals(6, origins.size());

        assertEquals("CSIA", origins.get(0).getCode());
        assertEquals("Chhatrapati Shivaji International Airport", origins.get(0).getName());

        assertEquals("JFKI", origins.get(1).getCode());
        assertEquals("John F. Kennedy International Airport", origins.get(1).getName());

        assertEquals("FKFI", origins.get(2).getCode());
        assertEquals("Frankfurt Airport", origins.get(2).getName());

        assertEquals("LIA", origins.get(3).getCode());
        assertEquals("Louisville International Airport", origins.get(3).getName());

        assertEquals("SFIA", origins.get(4).getCode());
        assertEquals("San Francisco International Airport", origins.get(4).getName());

        assertEquals("GBIA", origins.get(5).getCode());
        assertEquals("George Bush Intercontinental Airport", origins.get(5).getName());

    }

    @Test
    public void testFindDestinationsByOrigin_CSIA() {
        String originCode = "CSIA";
        AirportEntity destination1 = new AirportEntity("DFWI", "Dallas/Fort Worth International Airport");
        AirportEntity destination2 = new AirportEntity("SFIA", "San Francisco International Airport");

        List<AirportEntity> result = List.of(destination1,destination2);
        assertEquals(2, result.size());
        assertEquals("DFWI", result.get(0).getCode());
        assertEquals("Dallas/Fort Worth International Airport", result.get(0).getName());
        assertEquals("SFIA", result.get(1).getCode());
        assertEquals("San Francisco International Airport", result.get(1).getName());
    }

}

