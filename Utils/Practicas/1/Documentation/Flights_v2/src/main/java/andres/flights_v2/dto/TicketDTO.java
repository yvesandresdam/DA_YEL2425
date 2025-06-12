package andres.flights_v2.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO que representa la información de un ticket de vuelo.
 * Contiene detalles como ID del ticket, fechas de reserva y viaje,
 * así como los códigos del pasajero y del vuelo.
 */
public class TicketDTO {

    /**
     * Identificador único del ticket.
     */
    @Id
    private Integer id;

    /**
     * Fecha en que se realizó la reserva.
     */
    private LocalDate dateOfBooking;

    /**
     * Fecha programada para el viaje.
     */
    private LocalDate dateOfTravel;

    /**
     * Número de pasaporte del pasajero.
     * Máximo 10 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 10)
    private String passportno;

    /**
     * Código del vuelo asociado al ticket.
     * Máximo 10 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 10)
    private String flightCode;

    /**
     * Constructor por defecto.
     */
    public TicketDTO() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param id             Identificador del ticket
     * @param dateOfBooking  Fecha de reserva
     * @param dateOfTravel   Fecha de viaje
     * @param passportno     Número de pasaporte del pasajero
     * @param flightCode     Código del vuelo
     */
    public TicketDTO(Integer id, LocalDate dateOfBooking, LocalDate dateOfTravel, String passportno, String flightCode) {
        this.id = id;
        this.dateOfBooking = dateOfBooking;
        this.dateOfTravel = dateOfTravel;
        this.passportno = passportno;
        this.flightCode = flightCode;
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
}
