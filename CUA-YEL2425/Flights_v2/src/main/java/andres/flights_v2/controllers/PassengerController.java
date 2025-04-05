package andres.flights_v2.controllers;

import andres.flights_v2.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // Manual validation of the parameters
        if (passportno == null || passportno.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "El número de pasaporte es obligatorio"));
        }
        if (passportno.length() != 8) {
            return ResponseEntity.badRequest().body(Map.of("error", "El número de pasaporte debe tener exactamente 8 caracteres"));
        }

        Optional<?> passenger = passengerService.findPassengerByPassport(passportno);

        return passenger
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(Map.of("error", "Pasajero no encontrado")));
    }
}
