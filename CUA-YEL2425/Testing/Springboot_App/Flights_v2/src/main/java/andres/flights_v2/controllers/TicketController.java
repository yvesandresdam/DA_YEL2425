package andres.flights_v2.controllers;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/Tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    // Endpoint: POST, Requiere un objeto DTO Ticket para crear un ticket nuevo
    @PostMapping("/CreateTicket")
    public boolean createTicket(@RequestBody TicketDTO ticketDTO) {
        boolean ticketSuccess = ticketService.createTicket(ticketDTO);
        return ticketSuccess;
    }

    // Endpoint: Devuelve un booleano si existe un Ticket para un pasaporte y una fecha de vuelo
    @GetMapping("/{flightDate}/{passportno}")
    public boolean checkIfTicketExists(@PathVariable("flightDate")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightDate,
                                       @PathVariable("passportno") String passportNo) {
        boolean exists = ticketService.checkTicketExists(flightDate, passportNo);
        return exists;
    }
}
