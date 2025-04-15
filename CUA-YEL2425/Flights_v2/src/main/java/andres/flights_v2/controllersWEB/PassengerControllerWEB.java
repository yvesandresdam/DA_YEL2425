package andres.flights_v2.controllersWEB;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
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

    @GetMapping("/Passport/{passportno}")
    public ResponseEntity<?> findPassengerByPassport(@PathVariable String passportno) {
        try {
            PassengerDTO passenger = passengerService.findPassengerByPassport(passportno);
            if (passenger != null) {
                return ResponseEntity.ok(passenger);
            } else {
                Map<String, String> response = Map.of(
                        "error", "Passenger not found",
                        "message", "Would you like to create a new passport?",
                        "createPassportLink", "/CreateNewPassenger"
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping("/CreateNewPassenger")
    public String showCreateForm(Model model) {
        model.addAttribute("passenger", new PassengerDTO());
        return "new_user_page";
    }

    @PostMapping("/CreateNewPassenger/New")
    public String createNewPassenger(@ModelAttribute PassengerDTO passengerDTO, Model model) {
        try {
            PassengerEntity passengerEntity = new PassengerEntity();
            passengerEntity.setPassportno(passengerDTO.getPassportno());
            passengerEntity.setFirstname(passengerDTO.getFirstname());
            passengerEntity.setLastname(passengerDTO.getLastname());
            passengerEntity.setAddress(passengerDTO.getAddress());
            passengerEntity.setPhone(passengerDTO.getPhone());
            passengerEntity.setSex(passengerDTO.getSex());

            passengerService.createPassenger(passengerEntity);

            model.addAttribute("message", "Passenger created successfully!");
            model.addAttribute("passportno", passengerEntity.getPassportno());

            return "success_page";
        } catch (IllegalArgumentException ex) {
            return "error_page";
        }
    }
}
