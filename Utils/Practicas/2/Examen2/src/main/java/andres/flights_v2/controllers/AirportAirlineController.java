package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirlineEntity;
import andres.flights_v2.models.entities.AirportAirline;
import andres.flights_v2.service.AirportAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirportAirlineController {
    @Autowired
    public AirportAirlineService airlineService;

    @GetMapping("/{code}")
    public List<String> getAirlineWithCode(@PathVariable String code){
        return airlineService.getAirlineWithCode(code);
    }
}
