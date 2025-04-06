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

// Controller showing data info about entity 'Passenger'.
// The endpoints are managed with the 'passengerService' class.

@RestController
@RequestMapping("/Passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/Passport/{passportno}")
    public ResponseEntity<?> findPassengerByPassport(@PathVariable String passportno) {
        // VALIDATION - CONTROLLER LAYER
        // is passport valid_
        if (passportno == null || passportno.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Passport identity is mandatory."));
        }
        if (passportno.length() != 8) {
            return ResponseEntity.badRequest().body(Map.of("error", "Passport identity number must be 8 characters long."));
        }

        // passport is valid_
        Optional<?> passenger = passengerService.findPassengerByPassport(passportno);
        if (passenger.isPresent()) {
            return ResponseEntity.ok(passenger.get());
        } else {
            Map<String, String> response = Map.of(
                    "error", "Passenger not found",
                    "message", "Would you like to create a new passport?",
                    "createPassportLink", "/CreateNewPassenger"
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    @PostMapping("/CreateNewPassenger")
    public ResponseEntity<?> createNewPassenger(@RequestBody PassengerDTO passengerDTO) {

        // VALIDATION - CONTROLLER LAYER
        // is passport valid_
        if (passengerDTO.getPassportno() == null || passengerDTO.getPassportno().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Passport number is mandatory."));
        }
        if (passengerDTO.getPassportno().length() != 8) {
            return ResponseEntity.badRequest().body(Map.of("error", "Passport number must be exactly 8 characters long."));
        }

        // are names valid_
        if (passengerDTO.getFirstname() == null || passengerDTO.getFirstname().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "First name is mandatory."));
        }
        if (passengerDTO.getLastname() == null || passengerDTO.getLastname().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Last name is mandatory."));
        }

        // Convertir el DTO en una entidad PassengerEntity
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setPassportno(passengerDTO.getPassportno());
        passengerEntity.setFirstname(passengerDTO.getFirstname());
        passengerEntity.setLastname(passengerDTO.getLastname());
        passengerEntity.setAddress(passengerDTO.getAddress());
        passengerEntity.setPhone(passengerDTO.getPhone());
        passengerEntity.setSex(passengerDTO.getSex());

        // Guardar el nuevo pasajero en la base de datos
        passengerService.createPassenger(passengerEntity);

        // Responder con un mensaje de éxito
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Passenger created successfully", "passportno", passengerEntity.getPassportno()));
    }
}
