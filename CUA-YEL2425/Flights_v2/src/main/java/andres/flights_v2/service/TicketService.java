package andres.flights_v2.service;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.models.entities.FlightEntity;
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
        TicketEntity newTicket = new TicketEntity();
        newTicket.setId(ticket.getId());
        newTicket.setDateOfBooking(ticket.getDateOfBooking());
        newTicket.setDateOfTravel(ticket.getDateOfTravel());
        newTicket.setDateOfCancellation(ticket.getDateOfCancellation());
        newTicket.setPassportno(ticket.getPassportno());
        newTicket.setFlightCode(ticket.getFlightCode());
        newTicket.setPrice(ticket.getPrice());

        try{
            ticketDAO.save(newTicket);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

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
