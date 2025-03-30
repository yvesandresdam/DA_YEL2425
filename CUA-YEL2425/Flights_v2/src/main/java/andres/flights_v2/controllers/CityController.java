package andres.flights_v2.controllers;

import andres.flights_v2.entities.CityEntity;
import andres.flights_v2.models.CityEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/City")
public class CityController {

    // Controlador que contiene las funciones llamada desde cada endpoint de la API
    // Comunica el modelo Hibernate con la REST API
    @Autowired
    private CityEntityDAO cityDao;

    // Devuelve todos los campos de la tabla 'City'
    @GetMapping
    public List<CityEntity> findAllCities(){
        return (List<CityEntity>) cityDao.findAll();
    }

    // Devuelve el registro de la ciudad que coincide con el codigo de parametro
    @GetMapping("/{code}")
    public ResponseEntity<CityEntity> findCityByCode(@PathVariable(value = "code") String code){
        Optional<CityEntity> city = cityDao.findById(code);
        return ResponseEntity.ok(city.get());
    }

    // Devuelve el 'Country' que coincide con el parametro de consulta
    @GetMapping("/Country/{country}")
    public ResponseEntity<List<CityEntity>> findCityByCountry(@PathVariable("country") String country) {
        List<CityEntity> cities = cityDao.findByCountry(country);
        return ResponseEntity.ok(cities);
    }

    // Devuelve el 'Name' que coincide con el parametro de consulta
    @GetMapping("/Name/{name}")
    public ResponseEntity<CityEntity> findCityByName(@PathVariable("name") String name) {
        Optional<CityEntity> city = cityDao.findByName(name);
        return ResponseEntity.ok(city.get());
    }

    // Devuelve el 'State' que coincide con el parametro de consulta
    @GetMapping("/State/{state}")
    public ResponseEntity<List<CityEntity>> findCityByState(@PathVariable("state") String state) {
        List<CityEntity> cities = cityDao.findByState(state);
        return ResponseEntity.ok(cities);
    }
}
