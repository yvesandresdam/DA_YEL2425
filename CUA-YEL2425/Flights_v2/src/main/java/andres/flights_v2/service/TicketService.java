package andres.flights_v2.service;

import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private ITicketEntityDAO ticketDAO;

    public TicketEntity createTicket(TicketEntity ticket) {
        return ticketDAO.save(ticket);
    }

    public TicketEntity findTicketById(Integer ticketNumber) {
        Optional<TicketEntity> optionalTicket = ticketDAO.findById(ticketNumber);
        return optionalTicket.get();
    }

    public boolean checkTicketExists(LocalDate travelDate, String passportNo) {
        Boolean exists = ticketDAO.checkTicketExists(travelDate, passportNo);
        return exists != null && exists;
    }
}
