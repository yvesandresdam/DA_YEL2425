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

/**
 * Controlador MVC para la gestión de tickets desde la interfaz web.
 * Permite mostrar formularios y procesar la compra de tickets.
 */
@Controller
@RequestMapping("/Web/Tickets")
public class TicketsControllerWEB {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    /**
     * Endpoint: Devuelve la página con el formulario para comprar un ticket.
     * Añade al modelo la lista de aeropuertos de origen y un objeto TicketDTO vacío para el formulario.
     *
     * @param model Modelo para enviar atributos a la vista.
     * @return Nombre de la vista Thymeleaf con el formulario de compra de ticket.
     */
    @GetMapping("/CreateTicket")
    public String showCreateTicketForm(Model model) {
        List<AirportEntity> origins = flightService.findAllOrigins();
        model.addAttribute("origins", origins);
        model.addAttribute("ticketDTO", new TicketDTO());
        return "form_buy_ticket";
    }

    /**
     * Endpoint: Procesa el formulario para crear un ticket nuevo.
     * Valida el DTO recibido, llama al servicio para crear el ticket.
     * Si la creación es exitosa, muestra la página de éxito.
     * Si falla porque no existe el pasajero, redirige para crear pasajero nuevo.
     * Si hay error de negocio, devuelve el mensaje de error.
     *
     * @param ticketDTO DTO con los datos del ticket a crear.
     * @param model Modelo para enviar atributos a la vista.
     * @return Nombre de la vista Thymeleaf según el resultado de la operación.
     */
    @PostMapping("/CreateTicket")
    public String createNewTicket(@Valid @ModelAttribute TicketDTO ticketDTO, Model model) {
        try {
            boolean success = ticketService.createTicket(ticketDTO);
            if (success) {
                return "msg_ticket_success";
            } else {
                // Si el pasajero no existe, mostrar opción para crear nuevo pasajero
                model.addAttribute("passportno", ticketDTO.getPassportno());
                return "navigate_to_new_passenger";
            }
        } catch (IllegalArgumentException ex) {
            // Devolver mensaje de error (podrías querer mostrarlo en una vista específica)
            return ex.getMessage();
        }
    }
}
