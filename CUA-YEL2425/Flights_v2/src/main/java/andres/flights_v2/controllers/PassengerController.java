package andres.flights_v2.controllers;

import andres.flights_v2.entities.PassengerEntity;
import andres.flights_v2.models.PassengerEntityDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Passenger")
public class PassengerController {

    @Autowired
    private PassengerEntityDAO passengerDAO;

    @GetMapping
    public List<PassengerEntity> findAllPassengers(){
        return (List<PassengerEntity>) passengerDAO.findAll();
    }

    @GetMapping("/Passport/{passportno}")
    public ResponseEntity<PassengerEntity> findPassengerByPassport(@PathVariable(value = "passportno") String passport){
        Optional<PassengerEntity> passenger = passengerDAO.findByPassportno(passport);
        return ResponseEntity.ok(passenger.get());
    }

    @GetMapping("/Name/{firstname}")
    public ResponseEntity<PassengerEntity> findPassengerByName(@PathVariable("firstname") String name) {
        Optional<PassengerEntity> passenger = passengerDAO.findByFirstname(name);
        return ResponseEntity.ok(passenger.get());
    }

    @GetMapping("/Phone/{phone}")
    public ResponseEntity<PassengerEntity> findCityByName(@PathVariable("phone") String phone) {
        Optional<PassengerEntity> passenger = passengerDAO.findByPhone(phone);
        return ResponseEntity.ok(passenger.get());
    }
}
