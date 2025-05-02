package andres.flights_v2.controllersWEB;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import andres.flights_v2.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Web/Tickets")
public class TicketsControllerWEB {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/CreateTicket")
    public String showCreateTicketForm(Model model) {
        List<AirportEntity> origins = flightService.findAllOrigins();
        model.addAttribute("origins", origins);
        model.addAttribute("ticketDTO", new TicketDTO());
        return "form_page";
    }

    @PostMapping("/CreateTicket")
    public String createNewTicket(@Valid @ModelAttribute TicketDTO ticketDTO, Model model) {
        try {
            boolean success = ticketService.createTicket(ticketDTO);
            if (success) {
                return "success_page";
            } else {
                model.addAttribute("passportno", ticketDTO.getPassportno());
                return "new_passenger_msg";
            }
        } catch (IllegalArgumentException ex) {
            return "error_page";
        }
    }
}
