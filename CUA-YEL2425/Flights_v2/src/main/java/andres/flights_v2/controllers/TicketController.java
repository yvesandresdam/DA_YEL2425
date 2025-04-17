package andres.flights_v2.controllers;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.entities.FlightEntity;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.models.entities.TicketEntity;
import andres.flights_v2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/Tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/{flightDate}/{passportno}")
    public ResponseEntity<Boolean> checkIfTicketExists(@PathVariable("flightDate")
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightDate,
                                                       @PathVariable("passportno") String passportNo) {
        boolean exists = ticketService.checkTicketExists(flightDate, passportNo);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/createTicket")
    public boolean createTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.createTicket(ticketDTO);
        return true;
    }
}


