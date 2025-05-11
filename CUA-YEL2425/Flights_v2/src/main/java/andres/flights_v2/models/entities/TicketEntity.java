package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_id_gen")
    @SequenceGenerator(name = "tickets_id_gen", sequenceName = "ticket1_ticket_number_seq", allocationSize = 1)
    @Column(name = "ticket_number", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "date_of_booking", nullable = false)
    private LocalDate dateOfBooking;

    @NotNull
    @Column(name = "date_of_travel", nullable = false)
    private LocalDate dateOfTravel;

    @Column(name = "date_of_cancellation")
    private LocalDate dateOfCancellation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passportno", nullable = false)
    private PassengerEntity passenger;

    @NotNull
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
        return passenger;
    }

    public void setPassportno(PassengerEntity passportno) {
        this.passenger = passportno;
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