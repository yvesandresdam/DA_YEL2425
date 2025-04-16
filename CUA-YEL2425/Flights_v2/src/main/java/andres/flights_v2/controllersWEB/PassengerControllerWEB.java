package andres.flights_v2.controllersWEB;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/Web/Passenger")
public class PassengerControllerWEB {
    @Autowired
    private PassengerService passengerService;
    @GetMapping("/NewPassenger")
    public String showNewPassengerForm(Model model) {
        model.addAttribute("passenger", new PassengerDTO());
        return "new_passenger_page";
    }
    @PostMapping("/NewPassenger/Create")
    public ResponseEntity<String> createNewPassenger(@Valid @ModelAttribute PassengerDTO passengerDTO) {
        try {
            passengerService.createPassenger(passengerDTO);
            return ResponseEntity.ok("Pasajero creado");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
