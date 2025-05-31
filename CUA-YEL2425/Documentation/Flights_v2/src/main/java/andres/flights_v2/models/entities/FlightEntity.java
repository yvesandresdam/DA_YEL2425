package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa un vuelo en el sistema.
 *
 * Esta entidad está mapeada a la tabla "flights" de la base de datos.
 * Contiene la información básica de un vuelo, incluyendo su código,
 * aeropuertos de origen y destino, horas de salida y llegada, estado,
 * duración, tipo de vuelo y número de asientos.
 *
 * También incluye varias consultas nombradas (JPQL y nativas) para obtener
 * información relacionada con los vuelos.
 */
@NamedQueries({
        @NamedQuery(
                name = "FlightEntity.findAllOrigins",
                query = "SELECT DISTINCT f.source FROM FlightEntity f"
        ),
        @NamedQuery(
                name = "FlightEntity.findDestinationsByOrigin",
                query = "SELECT f.destination FROM FlightEntity f WHERE f.source.code = :originId"
        ),
        @NamedQuery(
                name = "FlightEntity.findFlightCodeByRoute",
                query = "SELECT f.flightCode FROM FlightEntity f WHERE f.source.code = :originId AND f.destination.code = :destinationId"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "FlightEntity.countSeatNumber",
                query = "SELECT yveeli_01_available_seats_int(:flightCode, :dateOfTravel)",
                resultClass = Integer.class
        ),
        @NamedNativeQuery(
                name = "FlightEntity.checkSeatAvailability",
                query = "SELECT yveeli_02_available_seats_bool(:flightCode, :dateOfTravel)",
                resultClass = Boolean.class
        )
})
@Entity
@Table(name = "flights")
public class FlightEntity {

    /**
     * Código identificador del vuelo.
     * Es la clave primaria de la tabla.
     */
    @Id
    @Size(max = 10)
    @Column(name = "flight_code", nullable = false, length = 10)
    private String flightCode;

    /**
     * Aeropuerto de origen del vuelo.
     * Relación muchos a uno con AirportEntity.
     */
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source", nullable = false)
    private AirportEntity source;

    /**
     * Aeropuerto de destino del vuelo.
     * Relación muchos a uno con AirportEntity.
     */
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination", nullable = false)
    private AirportEntity destination;

    /**
     * Hora estimada de llegada (formato HH:mm).
     */
    @Size(max = 10)
    @NotBlank
    @Column(name = "arrival", nullable = false, length = 10)
    private String arrival;

    /**
     * Hora estimada de salida (formato HH:mm).
     */
    @Size(max = 10)
    @NotBlank
    @Column(name = "departure", nullable = false, length = 10)
    private String departure;

    /**
     * Estado del vuelo (por ejemplo: "On Time", "Delayed").
     */
    @Size(max = 10)
    @Column(name = "status", length = 10)
    private String status;

    /**
     * Duración del vuelo en minutos.
     */
    @Column(name = "duration")
    private Integer duration;

    /**
     * Tipo de vuelo (por ejemplo: "Directo", "Escala").
     */
    @Size(max = 10)
    @Column(name = "flight_type", length = 10)
    private String flightType;

    /**
     * Tiempo de escala en minutos (si aplica).
     */
    @Column(name = "layover_time")
    private Integer layoverTime;

    /**
     * Número de escalas del vuelo.
     */
    @Column(name = "no_of_stops")
    private Integer noOfStops;

    /**
     * Número total de asientos disponibles en el vuelo.
     */
    @Column(name = "seats")
    private Integer seats;

    // Getters y setters

    /** @return código del vuelo */
    public String getFlightCode() {
        return flightCode;
    }

    /** @param flightCode nuevo código del vuelo */
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    /** @return aeropuerto de origen */
    public AirportEntity getSource() {
        return source;
    }

    /** @param source nuevo aeropuerto de origen */
    public void setSource(AirportEntity source) {
        this.source = source;
    }

    /** @return aeropuerto de destino */
    public AirportEntity getDestination() {
        return destination;
    }

    /** @param destination nuevo aeropuerto de destino */
    public void setDestination(AirportEntity destination) {
        this.destination = destination;
    }

    /** @return hora de llegada */
    public String getArrival() {
        return arrival;
    }

    /** @param arrival nueva hora de llegada */
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    /** @return hora de salida */
    public String getDeparture() {
        return departure;
    }

    /** @param departure nueva hora de salida */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /** @return estado del vuelo */
    public String getStatus() {
        return status;
    }

    /** @param status nuevo estado del vuelo */
    public void setStatus(String status) {
        this.status = status;
    }

    /** @return duración del vuelo en minutos */
    public Integer getDuration() {
        return duration;
    }

    /** @param duration nueva duración del vuelo */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /** @return tipo de vuelo */
    public String getFlightType() {
        return flightType;
    }

    /** @param flightType nuevo tipo de vuelo */
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    /** @return tiempo de escala en minutos */
    public Integer getLayoverTime() {
        return layoverTime;
    }

    /** @param layoverTime nuevo tiempo de escala */
    public void setLayoverTime(Integer layoverTime) {
        this.layoverTime = layoverTime;
    }

    /** @return número de escalas */
    public Integer getNoOfStops() {
        return noOfStops;
    }

    /** @param noOfStops nuevo número de escalas */
    public void setNoOfStops(Integer noOfStops) {
        this.noOfStops = noOfStops;
    }

    /** @return número total de asientos */
    public Integer getSeats() {
        return seats;
    }

    /** @param seats nuevo número total de asientos */
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
