package andres.flights_v2.controllers;

import andres.flights_v2.dto.TicketDTO;
import andres.flights_v2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Controlador REST para gestionar tickets.
 * Permite crear nuevos tickets y comprobar si un ticket ya existe para un pasajero en una fecha concreta.
 */
@RestController
@RequestMapping("/Tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * Endpoint: POST, Requiere un objeto DTO Ticket para crear un ticket nuevo.
     *
     * @param ticketDTO Objeto TicketDTO con los datos del ticket a crear.
     * @return true si el ticket fue creado correctamente, false en caso contrario.
     */
    @PostMapping("/CreateTicket")
    public boolean createTicket(@RequestBody TicketDTO ticketDTO) {
        boolean ticketSuccess = ticketService.createTicket(ticketDTO);
        return ticketSuccess;
    }

    /**
     * Endpoint: Devuelve un booleano si existe un Ticket para un pasaporte y una fecha de vuelo.
     *
     * @param flightDate Fecha del vuelo en formato yyyy-MM-dd.
     * @param passportNo Número de pasaporte del pasajero.
     * @return true si existe un ticket para ese pasajero y fecha, false si no.
     */
    @GetMapping("/{flightDate}/{passportno}")
    public boolean checkIfTicketExists(@PathVariable("flightDate")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightDate,
                                       @PathVariable("passportno") String passportNo) {
        boolean exists = ticketService.checkTicketExists(flightDate, passportNo);
        return exists;
    }
}
