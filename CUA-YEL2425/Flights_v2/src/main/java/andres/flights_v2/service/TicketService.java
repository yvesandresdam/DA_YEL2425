package andres.flights_v2.service;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketService {
    @Autowired
    private ITicketEntityDAO ticketDAO;

    public boolean createTicket(TicketDTO ticket) {
        // Create New Ticket
        TicketEntity newTicket = new TicketEntity();
        newTicket.setId(ticket.getId());
        newTicket.setDateOfBooking(LocalDate.now());
        newTicket.setDateOfTravel(ticket.getDateOfTravel());
        newTicket.setDateOfCancellation(null);
        newTicket.setFlightCode(ticketDAO.findFlightByFlightCode(ticket.getFlightCode()));
        newTicket.setPrice(150000);

        // Validating if passport exists
        PassengerEntity passenger = ticketDAO.findPassengerByPassportno(ticket.getPassportno());
        if (passenger == null)
            return false;
        newTicket.setPassportno(passenger);

        // Saving Ticket
        try {
            ticketDAO.save(newTicket);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // GENERIC FUNCTIONS - SERVICE LAYER -
    public TicketEntity findTicketById(Integer ticketNumber) {
        return ticketDAO.getTicketEntityById(ticketNumber);
    }

    // STORED PROCEDURES - SERVICE LAYER -
    // Function that checks if passenger has already bought a ticket
    public boolean checkTicketExists(LocalDate travelDate, String passportNo) {
        Boolean exists = ticketDAO.checkTicketExists(travelDate, passportNo);
        return exists != null && exists;
    }
}
