package andres.flights_v2.controllersWEB;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Web/Tickets")
public class TicketsControllerWEB {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/CreateTicket")
    public String createNewTicket(@Valid @ModelAttribute TicketDTO ticketDTO) {
        try {
            boolean success = ticketService.createTicket(ticketDTO);
            if (success)
                return "success_page";
            else return "new_passenger_msg";
        } catch (IllegalArgumentException ex) {
            return "error_page";
        }
    }
}
