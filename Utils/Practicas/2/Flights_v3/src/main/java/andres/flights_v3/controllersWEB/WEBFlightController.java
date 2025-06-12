package andres.flights_v3.controllersWEB;

import andres.flights_v3.entities.AirportEntity;
import andres.flights_v3.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WEBFlightController {
    @Autowired
    public FlightService flightService;

    @GetMapping("/tickets")
    public String displayTicketsView(Model model){
        List<AirportEntity> airports = flightService.getAllSources();
        model.addAttribute("airports", airports);
        return "ticket-view";
    }

}
