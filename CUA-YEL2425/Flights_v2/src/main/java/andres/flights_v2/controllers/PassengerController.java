package andres.flights_v2.controllers;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/Passport/{passportno}")
    public PassengerEntity findPassengerByPassport(@PathVariable String passportno) {
        return passengerService.findPassengerByPassport(passportno);
    }

    @PostMapping("/CreateNewPassenger")
    public boolean createNewPassenger(@RequestBody PassengerDTO passengerDTO) {
        return passengerService.createPassenger(passengerDTO);
    }
}
