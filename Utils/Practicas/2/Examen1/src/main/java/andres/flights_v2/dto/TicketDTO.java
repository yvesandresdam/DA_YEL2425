package andres.flights_v2.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TicketDTO {
    @Id
    private Integer id;
    private LocalDate dateOfBooking;
    private LocalDate dateOfTravel;

    @NotBlank
    @Size(max = 10)
    private String passportno;

    @NotBlank
    @Size(max = 10)
    private String flightCode;

    public TicketDTO() {
    }

    public TicketDTO(Integer id, LocalDate dateOfBooking, LocalDate dateOfTravel, String passportno, String flightCode) {
        this.id = id;
        this.dateOfBooking = dateOfBooking;
        this.dateOfTravel = dateOfTravel;
        this.passportno = passportno;
        this.flightCode = flightCode;
    }

    // _getters / setters_
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

