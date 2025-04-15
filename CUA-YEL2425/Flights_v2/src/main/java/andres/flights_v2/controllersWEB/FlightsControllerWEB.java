package andres.flights_v2.controllersWEB;


import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/Web/Flights")
public class FlightsControllerWEB {
    @Autowired
    private FlightService flightService;

    @GetMapping("/Origins")
    public String WebShowOrigins(Model model) {
        List<AirportEntity> origins = flightService.findAllOrigins();
        model.addAttribute("origins", origins);
        return "form_page";
    }

    @GetMapping("/Destinations/{originId}")
    @ResponseBody
    public ResponseEntity<?> getDestinations(@PathVariable String originId) {
        try {
            List<AirportEntity> destinations = flightService.findDestinationsByOrigin(originId);
            return ResponseEntity.ok(destinations);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping("/{originId}/{destinationId}")
    public ResponseEntity<?> findFlightCodeByRoute(@PathVariable String originId,
                                                   @PathVariable String destinationId) {
        try {
            Optional<List<String>> flightCode = flightService.findFlightCodeByRoute(originId, destinationId);
            return ResponseEntity.ok(flightCode.orElse(new ArrayList<String>()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}

