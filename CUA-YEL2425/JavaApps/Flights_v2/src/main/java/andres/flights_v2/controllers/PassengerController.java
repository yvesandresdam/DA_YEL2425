package andres.flights_v2.controllers;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    // Endpoint: POST, Requiere un objeto DTO Passenger para crear un pasajero nuevo
    @PostMapping("/CreateNewPassenger")
    public boolean createNewPassenger(@RequestBody PassengerDTO passengerDTO) {
        return passengerService.createPassenger(passengerDTO);
    }

    // Endpoint: Devuelve un objeto pasajero para un pasaporte
    @GetMapping("/Passport/{passportno}")
    public PassengerEntity findPassengerByPassport(@PathVariable String passportno) {
        return passengerService.findPassengerByPassport(passportno);
    }

}
