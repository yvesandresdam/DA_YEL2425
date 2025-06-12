package andres.flights_v2.service;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.models.dao.ITicketEntityDAO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Servicio para gestionar la compra y consulta de tickets.
 *
 * Proporciona métodos para crear tickets, buscar tickets por ID
 * y verificar si un pasajero ya ha comprado un ticket para una fecha dada.
 */
@Service
public class TicketService {

    @Autowired
    private ITicketEntityDAO ticketDAO;

    /**
     * Crea un nuevo ticket a partir de un DTO.
     * Asocia el ticket con el pasajero y vuelo correspondientes.
     *
     * @param ticket DTO con la información para crear el ticket.
     * @return true si el ticket se crea y guarda correctamente, false si no (por ejemplo, pasajero no encontrado).
     */
    public boolean createTicket(TicketDTO ticket) {
        TicketEntity newTicket = new TicketEntity();

        newTicket.setId(ticket.getId());
        newTicket.setDateOfBooking(LocalDate.now());
        newTicket.setDateOfTravel(ticket.getDateOfTravel());

        String flightCode = ticket.getFlightCode();
        newTicket.setFlightCode(ticketDAO.findFlightByFlightCode(flightCode));

        String passportno = ticket.getPassportno();
        PassengerEntity passenger = ticketDAO.findPassengerByPassportno(passportno);
        newTicket.setPassportno(passenger);

        if (passenger == null)
            return false;

        try {
            ticketDAO.save(newTicket);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Busca un ticket por su número de ticket (ID).
     *
     * @param ticketNumber identificador del ticket.
     * @return entidad TicketEntity correspondiente, o null si no se encuentra.
     */
    public TicketEntity findTicketById(Integer ticketNumber) {
        return ticketDAO.getTicketEntityById(ticketNumber);
    }

    /**
     * Llama a un procedimiento almacenado para verificar si un pasajero
     * ya ha comprado un ticket para una fecha específica.
     *
     * @param travelDate fecha de viaje a consultar.
     * @param passportNo número de pasaporte del pasajero.
     * @return true si existe ya un ticket para ese pasajero y fecha, false si no.
     */
    public boolean checkTicketExists(LocalDate travelDate, String passportNo) {
        Boolean exists = ticketDAO.checkTicketExists(travelDate, passportNo);
        return exists != null && exists;
    }
}
