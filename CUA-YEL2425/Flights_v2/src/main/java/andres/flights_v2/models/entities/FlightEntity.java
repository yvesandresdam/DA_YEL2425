package andres.flights_v2.models.entities;

import jakarta.persistence.*;

// Hibernate class that maps the entity 'flight'.
// The id of the entity is 'flightCode'.

@Entity
@Table(name = "flights")
public class FlightEntity {
    @Id
    @Column(name = "flight_code", nullable = false, length = 10)
    private String flightCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source", nullable = false)
    private AirportEntity source;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination", nullable = false)
    private AirportEntity destination;

    @Column(name = "arrival", nullable = false, length = 10)
    private String arrival;

    @Column(name = "departure", nullable = false, length = 10)
    private String departure;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "flight_type", length = 10)
    private String flightType;

    @Column(name = "layover_time")
    private Integer layoverTime;

    @Column(name = "no_of_stops")
    private Integer noOfStops;

    @Column(name = "seats")
    private Integer seats;

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public AirportEntity getSource() {
        return source;
    }

    public void setSource(AirportEntity source) {
        this.source = source;
    }

    public AirportEntity getDestination() {
        return destination;
    }

    public void setDestination(AirportEntity destination) {
        this.destination = destination;
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