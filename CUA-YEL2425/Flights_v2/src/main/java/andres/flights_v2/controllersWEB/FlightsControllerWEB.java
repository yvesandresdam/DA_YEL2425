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
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    @GetMapping("/{originId}/{destinationId}")
    @ResponseBody
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                              @PathVariable String destinationId) {
       return flightService.findFlightCodeByRoute(originId, destinationId);
    }
}

