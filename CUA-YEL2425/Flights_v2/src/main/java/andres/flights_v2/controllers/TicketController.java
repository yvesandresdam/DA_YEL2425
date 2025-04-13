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

    @PostMapping("/createTicket")
    public ResponseEntity<?> createTicket(@RequestBody TicketDTO ticketDTO) {
        try {
            TicketEntity ticketEntity = new TicketEntity();

            ticketEntity.setDateOfBooking(ticketDTO.getDateOfBooking());
            ticketEntity.setDateOfTravel(ticketDTO.getDateOfTravel());
            ticketEntity.setDateOfCancellation(ticketDTO.getDateOfCancellation());
            ticketEntity.setPrice(ticketDTO.getPrice());

            //TODO
            PassengerEntity passenger = new PassengerEntity();
            passenger.setPassportno("Y1234567");
            FlightEntity flight = new FlightEntity();
            flight.setFlightCode("YEL12");
            ticketEntity.setPassportno(passenger);
            ticketEntity.setFlightCode(flight);

            ticketService.createTicket(ticketEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Map.of("message", "Passenger created successfully", "passportno", passenger.getPassportno())
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}


