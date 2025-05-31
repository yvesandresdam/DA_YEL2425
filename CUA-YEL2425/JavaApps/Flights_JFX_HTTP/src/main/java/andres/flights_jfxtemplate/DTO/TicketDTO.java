package andres.flights_jfxtemplate.DTO;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TicketDTO {
    @Id
    private Integer id;

    private LocalDate dateOfBooking;

    private LocalDate dateOfTravel;

    private LocalDate dateOfCancellation;

    @NotBlank
    @Size(max = 10)
    private String passportno;

    @NotBlank
    @Size(max = 10)
    private String flightCode;

    private Integer price;

    public TicketDTO() {
    }

    public TicketDTO(Integer id, LocalDate dateOfBooking, LocalDate dateOfTravel, LocalDate dateOfCancellation, String passportno, String flightCode, Integer price) {
        this.id = id;
        this.dateOfBooking = dateOfBooking;
        this.dateOfTravel = dateOfTravel;
        this.dateOfCancellation = dateOfCancellation;
        this.passportno = passportno;
        this.flightCode = flightCode;
        this.price = price;
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

    public LocalDate getDateOfCancellation() {
        return dateOfCancellation;
    }

    public void setDateOfCancellation(LocalDate dateOfCancellation) {
        this.dateOfCancellation = dateOfCancellation;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

