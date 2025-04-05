package andres.flights_v2.service;

import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.models.dto.TicketDTO;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private ITicketEntityDAO ticketDAO;

    public TicketEntity createTicket(TicketEntity ticket) {
        return ticketDAO.save(ticket);
    }

//    public Optional<TicketDTO> findTicketById(Integer id) {
//        return ticketDAO.findById(id).map(this::convertToDTO);
//    }

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
