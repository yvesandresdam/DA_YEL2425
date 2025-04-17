package andres.flights_v2.dto;

import andres.flights_v2.models.entities.FlightEntity;
import andres.flights_v2.models.entities.PassengerEntity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TicketDTO {
    @Id
    @NotBlank
    private Integer id;

    @NotBlank
    private LocalDate dateOfBooking;

    @NotBlank
    private LocalDate dateOfTravel;

    private LocalDate dateOfCancellation;

    @NotBlank
    @Size(max = 10)
    private PassengerEntity passportno;

    @NotBlank
    @Size(max = 10)
    private FlightEntity flightCode;

    private Integer price;

    public TicketDTO() {
    }

    public TicketDTO(Integer id, LocalDate dateOfBooking, LocalDate dateOfTravel, LocalDate dateOfCancellation, PassengerEntity passportno, FlightEntity flightCode, Integer price) {
        this.id = id;
        this.dateOfBooking = dateOfBooking;
        this.dateOfTravel = dateOfTravel;
        this.dateOfCancellation = dateOfCancellation;
        this.passportno = passportno;
        this.flightCode = flightCode;
        this.price = price;
    }

    // Getters y setters
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

