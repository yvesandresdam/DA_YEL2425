package andres.flights_v2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para representar los datos de un vuelo.
 *
 * Contiene información sobre códigos de vuelo, origen, destino,
 * horarios, estado, duración y otros detalles relevantes.
 */
public class FlightDTO {

    /**
     * Código único del vuelo.
     * Máximo 10 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 10)
    private String flightCode;

    /**
     * Código del aeropuerto de origen.
     * Máximo 4 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 4)
    private String sourceCode;

    /**
     * Código del aeropuerto de destino.
     * Máximo 4 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 4)
    private String destinationCode;

    /**
     * Hora de llegada.
     * Máximo 10 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 10)
    private String arrival;

    /**
     * Hora de salida.
     * Máximo 10 caracteres, obligatorio.
     */
    @NotBlank
    @Size(max = 10)
    private String departure;

    /**
     * Estado actual del vuelo (opcional).
     * Máximo 10 caracteres.
     */
    @Size(max = 10)
    private String status;

    /**
     * Duración del vuelo en minutos (opcional).
     */
    private Integer duration;

    /**
     * Tipo de vuelo (opcional).
     * Máximo 10 caracteres.
     */
    @Size(max = 10)
    private String flightType;

    /**
     * Tiempo de escala en minutos (opcional).
     */
    private Integer layoverTime;

    /**
     * Número de paradas del vuelo (opcional).
     */
    private Integer noOfStops;

    /**
     * Número de asientos disponibles (opcional).
     */
    private Integer seats;

    /**
     * Constructor por defecto.
     */
    public FlightDTO() {}

    /**
     * Constructor completo con todos los atributos.
     */
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

    // Getters y Setters

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
