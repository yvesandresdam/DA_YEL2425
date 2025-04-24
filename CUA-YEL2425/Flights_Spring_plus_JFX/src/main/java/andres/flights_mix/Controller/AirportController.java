package andres.flights_mix.Controller;

import andres.flights_mix.Models.AirportEntity;
import andres.flights_mix.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/names")
    public List<String> findAllNames() {
        return airportService.findAllNames();
    }
}

