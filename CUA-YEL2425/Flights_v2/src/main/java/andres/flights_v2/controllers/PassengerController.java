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
    public PassengerEntity findPassengerByPassport(@PathVariable String passportno) {
        return passengerService.findPassengerByPassport(passportno);
    }
    // TODO
//    @GetMapping("/Passport/{passportno}")
//    public ResponseEntity<?> findPassengerByPassport(@PathVariable String passportno) {
//        try {
//            Optional<?> passenger = passengerService.findPassengerByPassport(passportno);
//            if (passenger.isPresent()) {
//                return ResponseEntity.ok(passenger.get());
//            } else {
//                Map<String, String> response = Map.of(
//                        "error", "Passenger not found",
//                        "message", "Would you like to create a new passport?",
//                        "createPassportLink", "/CreateNewPassenger"
//                );
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//            }
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
//        }
//    }


    @PostMapping("/CreateNewPassenger")
    public ResponseEntity<?> createNewPassenger(@RequestBody PassengerDTO passengerDTO) {
        try {
            PassengerEntity passengerEntity = new PassengerEntity();
            passengerEntity.setPassportno(passengerDTO.getPassportno());
            passengerEntity.setFirstname(passengerDTO.getFirstname());
            passengerEntity.setLastname(passengerDTO.getLastname());
            passengerEntity.setAddress(passengerDTO.getAddress());
            passengerEntity.setPhone(passengerDTO.getPhone());
            passengerEntity.setSex(passengerDTO.getSex());

            passengerService.createPassenger(passengerDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Map.of("message", "Passenger created successfully", "passportno", passengerEntity.getPassportno())
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}
