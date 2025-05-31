package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Representa un ticket de vuelo emitido para un pasajero.
 *
 * Esta entidad está mapeada a la tabla "tickets" de la base de datos.
 * Contiene información sobre la reserva, como fechas, pasajero, vuelo y precio.
 *
 * También incluye algunas consultas nativas que permiten verificar si ya existe un ticket,
 * y recuperar información asociada como el pasajero o el vuelo correspondiente.
 */
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "TicketEntity.checkTicketExists",
                query = "SELECT yveeli_03_ticket_already_exists(:travelDate, :passportNo)",
                resultClass = Boolean.class
        ),
        @NamedNativeQuery(
                name = "TicketEntity.findPassengerByPassportno",
                query = "SELECT * FROM passengers WHERE passportno = :passportno",
                resultClass = PassengerEntity.class
        ),
        @NamedNativeQuery(
                name = "TicketEntity.findFlightByFlightCode",
                query = "SELECT * FROM flights WHERE flight_code = :flightCode",
                resultClass = FlightEntity.class
        )
})
@Entity
@Table(name = "tickets")
public class TicketEntity {

    /**
     * Identificador único del ticket (clave primaria).
     * Se genera automáticamente usando una secuencia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_id_gen")
    @SequenceGenerator(name = "tickets_id_gen", sequenceName = "ticket1_ticket_number_seq", allocationSize = 1)
    @Column(name = "ticket_number", nullable = false)
    private Integer id;

    /**
     * Fecha en la que se hizo la reserva del ticket.
     */
    @NotNull
    @Column(name = "date_of_booking", nullable = false)
    private LocalDate dateOfBooking;

    /**
     * Fecha en la que el pasajero tiene previsto viajar.
     */
    @NotNull
    @Column(name = "date_of_travel", nullable = false)
    private LocalDate dateOfTravel;

    /**
     * Fecha en la que el ticket fue cancelado, si corresponde.
     * Puede ser null si el ticket no ha sido cancelado.
     */
    @Column(name = "date_of_cancellation")
    private LocalDate dateOfCancellation;

    /**
     * Pasajero al que pertenece el ticket.
     * Relación muchos-a-uno con la entidad PassengerEntity.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passportno", nullable = false)
    private PassengerEntity passenger;

    /**
     * Vuelo reservado en el ticket.
     * Relación muchos-a-uno con la entidad FlightEntity.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_code", nullable = false)
    private FlightEntity flightCode;

    /**
     * Precio del ticket en euros.
     */
    @Column(name = "price")
    private Integer price;

    // Getters y setters

    /** @return ID del ticket */
    public Integer getId() {
        return id;
    }

    /** @param id nuevo ID del ticket */
    public void setId(Integer id) {
        this.id = id;
    }

    /** @return fecha de reserva */
    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    /** @param dateOfBooking nueva fecha de reserva */
    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    /** @return fecha de viaje */
    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    /** @param dateOfTravel nueva fecha de viaje */
    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    /** @return fecha de cancelación (puede ser null) */
    public LocalDate getDateOfCancellation() {
        return dateOfCancellation;
    }

    /** @param dateOfCancellation nueva fecha de cancelación */
    public void setDateOfCancellation(LocalDate dateOfCancellation) {
        this.dateOfCancellation = dateOfCancellation;
    }

    /** @return pasajero asociado al ticket */
    public PassengerEntity getPassportno() {
        return passenger;
    }

    /** @param passportno nuevo pasajero asociado */
    public void setPassportno(PassengerEntity passportno) {
        this.passenger = passportno;
    }

    /** @return vuelo asociado al ticket */
    public FlightEntity getFlightCode() {
        return flightCode;
    }

    /** @param flightCode nuevo vuelo asociado */
    public void setFlightCode(FlightEntity flightCode) {
        this.flightCode = flightCode;
    }

    /** @return precio del ticket */
    public Integer getPrice() {
        return price;
    }

    /** @param price nuevo precio del ticket */
    public void setPrice(Integer price) {
        this.price = price;
    }
}
