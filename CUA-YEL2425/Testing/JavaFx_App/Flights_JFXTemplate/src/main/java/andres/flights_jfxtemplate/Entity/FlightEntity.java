package andres.flights_jfxtemplate.Entity;

public class FlightEntity {
    private String flight_code;
    private String source;
    private String destination;
    private String airlineid;

    public FlightEntity(String flight_code) {
        this.flight_code = flight_code;
    }

    public FlightEntity(String flight_code, String source, String destination, String airlineid) {
        this.flight_code = flight_code;
        this.source = source;
        this.destination = destination;
        this.airlineid = airlineid;
    }

    public String getFlightCode() {
        return flight_code;
    }

    @Override
    public String toString() {
        return flight_code;
    }
}
