package andres.flights_v2.controllersWEB;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.dao.IPassengerEntityDAO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/Web/Passenger")
public class PassengerControllerWEB {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private IPassengerEntityDAO DAO;

    @GetMapping("/NewPassenger")
    public String showNewPassengerForm(@RequestParam(name = "passportno", required = false) String passportno, Model model) {
        PassengerDTO passenger = new PassengerDTO();
        if (passportno != null) {
            passenger.setPassportno(passportno);
        }
        model.addAttribute("passenger", passenger);
        return "new_passenger_page";
    }

    @PostMapping("/NewPassenger/Create/TEST")
    public String createNewPassenger(@Valid @ModelAttribute("passenger") PassengerDTO passengerDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Errores: " + result.getAllErrors());
            model.addAttribute("passenger", passengerDTO);
            return "new_passenger_page";
        }

        model.addAttribute("firstname", passengerDTO.getFirstname());
        model.addAttribute("lastname", passengerDTO.getLastname());
        model.addAttribute("passportno", passengerDTO.getPassportno());
        model.addAttribute("address", passengerDTO.getAddress());
        model.addAttribute("phone", passengerDTO.getPhone());
        model.addAttribute("sex", passengerDTO.getSex());

        PassengerEntity passenger = new PassengerEntity();
        passenger.setFirstname(passengerDTO.getFirstname());
        passenger.setLastname(passengerDTO.getLastname());
        passenger.setPassportno(passengerDTO.getPassportno());
        passenger.setAddress(passengerDTO.getAddress());
        passenger.setPhone(passengerDTO.getPhone());
        passenger.setSex(passengerDTO.getSex());

        DAO.save(passenger);

        return "show_passenger_info";
    }
}

/*
    @PostMapping("/NewPassenger/Create")
    public String createNewPassenger(@Valid @ModelAttribute PassengerDTO passengerDTO, BindingResult result) {
//        if (result.hasErrors()) {
//            return "new_passenger_page";
//        }
        try {
            //passengerService.createPassenger(passengerDTO);
            return "form_page";
        } catch (IllegalArgumentException ex) {
            return "error_page";
        }
    }
 */
