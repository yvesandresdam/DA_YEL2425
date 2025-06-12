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
@RequestMapping("/city")
public class CityController {
    @Autowired
    public CityService cityService;

    @GetMapping("/{code}")
    public CityEntity getCityWithCode(@PathVariable String code){
        return cityService.getCityWithCode(code);
    }
    @GetMapping("/all")
    public List<CityEntity> getAllCities(){
        return cityService.getAllCities();
    }
}
