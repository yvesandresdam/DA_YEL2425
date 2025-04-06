package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

// Hibernate class that maps the entity 'tickets'.
// The id of the entity is 'ticket_number'.

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_id_gen")
    @SequenceGenerator(name = "tickets_id_gen", sequenceName = "ticket1_ticket_number_seq", allocationSize = 1)
    @Column(name = "ticket_number", nullable = false)
    private Integer id;

    @Column(name = "date_of_booking", nullable = false)
    private LocalDate dateOfBooking;

    @Column(name = "date_of_travel", nullable = false)
    private LocalDate dateOfTravel;

    @Column(name = "date_of_cancellation")
    private LocalDate dateOfCancellation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passportno", nullable = false)
    private PassengerEntity passportno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_code", nullable = false)
    private FlightEntity flightCode;

    @Column(name = "price")
    private Integer price;

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

    public LocalDate getDateOfCancellation() {
        return dateOfCancellation;
    }

    public void setDateOfCancellation(LocalDate dateOfCancellation) {
        this.dateOfCancellation = dateOfCancellation;
    }

    public PassengerEntity getPassportno() {
        return passportno;
    }

    public void setPassportno(PassengerEntity passportno) {
        this.passportno = passportno;
    }

    public FlightEntity getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(FlightEntity flightCode) {
        this.flightCode = flightCode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}