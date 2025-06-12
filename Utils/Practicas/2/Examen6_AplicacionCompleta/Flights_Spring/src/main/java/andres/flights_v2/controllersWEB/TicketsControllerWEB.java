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

    // Endpoint: Returns the main page of TICKETS BUYS.
    @GetMapping("/CreateTicket")
    public String displayCreateTicketForm(Model model) {
        List<AirportEntity> origins = flightService.findAllOrigins();
        model.addAttribute("origins", origins);
        model.addAttribute("ticketDTO", new TicketDTO());
        return "form_buy_ticket";
    }

    // Endpoint: POST, creates a new TICKET with a TICKET DTO
    @PostMapping("/CreateTicket")
    public String createNewTicket(@Valid @ModelAttribute TicketDTO ticketDTO, Model model) {
        try {
            boolean success = ticketService.createTicket(ticketDTO);
            if (success) {
                return "msg_ticket_success";
            } else {
                model.addAttribute("passportno", ticketDTO.getPassportno());
                return "navigate_to_new_passenger";
            }
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}
