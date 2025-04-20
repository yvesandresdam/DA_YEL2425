package andres.flights_v2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FlightDTO {

    @NotBlank
    @Size(max = 10)
    private String flightCode;

    @NotBlank
    @Size(max = 4)
    private String sourceCode;

    @NotBlank
    @Size(max = 4)
    private String destinationCode;

    @NotBlank
    @Size(max = 10)
    private String arrival;

    @NotBlank
    @Size(max = 10)
    private String departure;

    @Size(max = 10)
    private String status;

    private Integer duration;

    @Size(max = 10)
    private String flightType;

    private Integer layoverTime;

    private Integer noOfStops;

    private Integer seats;

    public FlightDTO() {}

    public FlightDTO(String flightCode, String sourceCode, String destinationCode, String arrival, String departure,
                     String status, Integer duration, String flightType, Integer layoverTime,
                     Integer noOfStops, Integer seats) {
        this.flightCode = flightCode;
        this.sourceCode = sourceCode;
        this.destinationCode = destinationCode;
        this.arrival = arrival;
        this.departure = departure;
        this.status = status;
        this.duration = duration;
        this.flightType = flightType;
        this.layoverTime = layoverTime;
        this.noOfStops = noOfStops;
        this.seats = seats;
    }

    // _getters / setters_
    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public Integer getLayoverTime() {
        return layoverTime;
    }

    public void setLayoverTime(Integer layoverTime) {
        this.layoverTime = layoverTime;
    }

    public Integer getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(Integer noOfStops) {
        this.noOfStops = noOfStops;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}

