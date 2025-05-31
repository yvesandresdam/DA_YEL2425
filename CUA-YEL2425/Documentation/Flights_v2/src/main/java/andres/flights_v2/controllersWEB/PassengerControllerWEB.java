package andres.flights_v2.controllersWEB;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.dao.IPassengerEntityDAO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador MVC para la gestión de pasajeros desde la interfaz web.
 * Gestiona la creación y visualización de formularios para pasajeros.
 */
@Controller
@RequestMapping("/Web/Passenger")
public class PassengerControllerWEB {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private IPassengerEntityDAO passengerDAO;

    /**
     * Endpoint: Muestra el formulario para crear un nuevo pasajero.
     * Si se pasa un passportno como parámetro, se pre-llena el formulario con ese dato.
     *
     * @param passportno (opcional) Pasaporte para pre-llenar el formulario.
     * @param model Modelo para enviar atributos a la vista.
     * @return Nombre de la vista Thymeleaf para el formulario de nuevo pasajero.
     */
    @GetMapping("/NewPassenger")
    public String showNewPassengerForm(@RequestParam(name = "passportno", required = false) String passportno, Model model) {
        PassengerDTO passenger = new PassengerDTO();
        if (passportno != null) {
            passenger.setPassportno(passportno);
        }
        model.addAttribute("passenger", passenger);
        return "form_new_passenger";
    }

    /**
     * Endpoint: Procesa el formulario enviado para crear un nuevo pasajero.
     * Valida los datos del DTO y si hay errores vuelve a mostrar el formulario.
     * Si la validación es correcta, guarda el pasajero y muestra una página de confirmación.
     *
     * @param passengerDTO Datos del pasajero recibidos desde el formulario.
     * @param result Resultado de la validación de los datos.
     * @param model Modelo para enviar atributos a la vista.
     * @return Nombre de la vista Thymeleaf con el mensaje de confirmación o el formulario con errores.
     */
    @PostMapping("/NewPassenger/Create")
    public String createNewPassenger(@Valid @ModelAttribute("passenger") PassengerDTO passengerDTO,
                                     BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("passenger", passengerDTO);
            return "form_new_passenger";
        }

        // Añadimos atributos para mostrar info en la vista de confirmación
        model.addAttribute("firstname", passengerDTO.getFirstname());
        model.addAttribute("lastname", passengerDTO.getLastname());
        model.addAttribute("passportno", passengerDTO.getPassportno());
        model.addAttribute("address", passengerDTO.getAddress());
        model.addAttribute("phone", passengerDTO.getPhone());
        model.addAttribute("sex", passengerDTO.getSex());

        // Convertir DTO a Entity para guardar en la base de datos
        PassengerEntity passenger = new PassengerEntity();
        passenger.setFirstname(passengerDTO.getFirstname());
        passenger.setLastname(passengerDTO.getLastname());
        passenger.setPassportno(passengerDTO.getPassportno());
        passenger.setAddress(passengerDTO.getAddress());
        passenger.setPhone(passengerDTO.getPhone());
        passenger.setSex(passengerDTO.getSex());

        passengerDAO.save(passenger);
        return "msg_passenger_info";
    }
}
