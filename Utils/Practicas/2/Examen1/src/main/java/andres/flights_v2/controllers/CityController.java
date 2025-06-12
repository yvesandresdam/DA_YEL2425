package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.CityEntity;
import andres.flights_v2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/all")
    public List<CityEntity> getAllcities(){
        return cityService.getAllCities();
    }

    @GetMapping("/{codigo}")
    public List<CityEntity> getCityWithCode(@PathVariable String codigo){
        return cityService.getCityWithCode(codigo);
    }

    @GetMapping("/allcodes")
    public List<String> getAllCodes(){
        return cityService.getAllCodes();
    }

    @GetMapping("/partial/{codigo}")
    public List<String> getPartialCity(@PathVariable String codigo){
        return cityService.getParcialCityWithCode(codigo);
    }
}
