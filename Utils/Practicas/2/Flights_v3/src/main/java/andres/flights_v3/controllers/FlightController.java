package andres.flights_v3.controllers;

import andres.flights_v3.entities.AirportEntity;
import andres.flights_v3.entities.CityEntity;
import andres.flights_v3.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    public FlightService flightService;

    @GetMapping("/origins/all")
    public List<AirportEntity> getAllSources(){
        return flightService.getAllSources();
    }

    /* TODO ■                                              ■ Endpoint con variable de ruta
    /*///
    @GetMapping("/city/{code}")
    public CityEntity getCityWithCode(@PathVariable String code){
        return flightService.getCityWithCode(code);
    }

    /* TODO ■                                              ■ Endpoint con variable requerida
    /*///
    @GetMapping("/cityalt")
    public CityEntity getCityWithCode2(@RequestParam ("codeCity") String code){
        return flightService.getCityWithCode(code);
    }
}
