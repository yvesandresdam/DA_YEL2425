package andres.flights_v2.controllersWEB;


import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // Endpoint: Devuelve todos los origenes posibles
    @GetMapping("/Origins")
    @ResponseBody
    public List<AirportEntity> findOrigins() {
        return flightService.findAllOrigins();
    }

    // Endpoint: Devuelve todos los destinos para un origen
    @GetMapping("/Destinations/{originId}")
    @ResponseBody
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    // Devuelve una lista de codigos de vuelo para un origen y un destino
    @GetMapping("/{originId}/{destinationId}")
    @ResponseBody
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                              @PathVariable String destinationId) {
       return flightService.findFlightCodeByRoute(originId, destinationId);
    }
}

