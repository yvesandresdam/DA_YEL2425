package andres.flights_v2.controllers;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.entities.TicketEntity;
import andres.flights_v2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/Tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    public TicketEntity createTicket(TicketEntity ticket) {
        return ticketService.createTicket(ticket);
    }
    public TicketEntity findTicketById(Integer id) {
        return ticketService.findTicketById(id);
    }

    @GetMapping("/{flightDate}/{passportno}")
    public ResponseEntity<Boolean> checkIfTicketExists(@PathVariable("flightDate")
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightDate,
                                                       @PathVariable("passportno") String passportNo) {
        boolean exists = ticketService.checkTicketExists(flightDate, passportNo);
        return ResponseEntity.ok(exists);
    }
}


