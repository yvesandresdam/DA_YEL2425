package andres.flights_v2.controllersWEB;


import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Web/Flights")
public class FlightsControllerWEB {
    @Autowired
    private FlightService flightService;

    // Endpoint: Returns a of ORIGINS Airports.
    @GetMapping("/Origins")
    @ResponseBody
    public List<AirportEntity> findOrigins() {
        return flightService.findAllOrigins();
    }

    // Endpoint: Returns a list of DESTINATIONS Airports with an ORIGIN_ID.
    @GetMapping("/Destinations/{originId}")
    @ResponseBody
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    // Endpoint_ Returns a list of FLIGHTCODE with and ORIGINS_ID and DESTINATION_ID.
    @GetMapping("/{originId}/{destinationId}")
    @ResponseBody
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                              @PathVariable String destinationId) {
       return flightService.findFlightCodeByRoute(originId, destinationId);
    }
}

