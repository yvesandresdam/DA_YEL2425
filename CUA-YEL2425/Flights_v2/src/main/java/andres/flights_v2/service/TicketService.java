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
        // TicketDTO -> TicketEntity
        TicketEntity newTicket = new TicketEntity();

        // ID
        newTicket.setId(ticket.getId());

        // Booking Today date
        newTicket.setDateOfBooking(LocalDate.now());
        // Booking travel date
        newTicket.setDateOfTravel(ticket.getDateOfTravel());

        // Flight Entity with flight_code
        String flightCode = ticket.getFlightCode();
        newTicket.setFlightCode(ticketDAO.findFlightByFlightCode(flightCode));

        // Passenger passport
        String passportno = ticket.getPassportno();
        PassengerEntity passenger = ticketDAO.findPassengerByPassportno(passportno);
        newTicket.setPassportno(passenger);

        if (passenger == null)
            return false;

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
