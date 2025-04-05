package andres.flights_v2.controllers;

import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.models.dto.TicketDTO;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketController {

    @Autowired
    private ITicketEntityDAO ticketDAO;

    public TicketEntity createTicket(TicketEntity ticket) {
        return ticketDAO.save(ticket);
    }

    public Optional<TicketDTO> findTicketById(Integer id) {
        return ticketDAO.findById(id).map(this::convertToDTO);
    }

    private TicketDTO convertToDTO(TicketEntity ticket) {
        return new TicketDTO(
                ticket.getId(),
                ticket.getDateOfBooking(),
                ticket.getDateOfTravel(),
                ticket.getDateOfCancellation(),
                ticket.getPassportno().getPassportno(),
                ticket.getFlightCode().getFlightCode(),
                ticket.getPrice()
        );
    }
}

/*
import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
    @Autowired
    private ITicketEntityDAO ticketDAO;

    @PostMapping("/Ticket_creation")
    public ResponseEntity<TicketEntity> crearTicket(@RequestBody TicketEntity ticket) {
        TicketEntity nuevoTicket = ticketDAO.save(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }
}

 */


