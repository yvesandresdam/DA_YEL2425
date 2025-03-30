package andres.flights_v2.controllers;

import andres.flights_v2.entities.AirportEntity;
import andres.flights_v2.entities.CityEntity;
import andres.flights_v2.models.AirportEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Airport")
public class AirportController {
    // Objeto DAO que enlaza con el modelo
    @Autowired
    private AirportEntityDAO airportDAO;

    // Funcion que devuelve todos los campos de la tabla Aeropuerto
    @GetMapping
    public List<AirportEntity> findAllAirports(){
        return (List<AirportEntity>) airportDAO.findAll();
    }

    // Funcion que devuelve un Aeropuerto que coincide con el codigo parametro
    @GetMapping("/Code/{code}")
    public ResponseEntity<AirportEntity> findAirportByCode(@PathVariable(value = "code") String code){
        Optional<AirportEntity> airport = airportDAO.findAirportByCode(code);
        return ResponseEntity.ok(airport.get());
    }

    // Funcion que devuelve un Aeropuerto que coincide con el codigo parametro de ciudad
    @GetMapping("/City/{city}")
    public ResponseEntity<AirportEntity> findAirportByCity(@PathVariable(value = "city") String city){
        Optional<AirportEntity> airport = airportDAO.findAirportByCity(city);
        return ResponseEntity.ok(airport.get());
    }
}

