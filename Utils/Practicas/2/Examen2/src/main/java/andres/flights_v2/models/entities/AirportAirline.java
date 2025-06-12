package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@NamedQuery(
        name="AirportAirline.getAirlineCodeWithAirportCode",
        //query = "SELECT a.airlineid FROM AirportAirline a WHERE a.airportid = :airportCode"
        //query = "SELECT airline.name FROM AirlineEntity airline, AirportAirline airport WHERE airport.airportid = :airportCode"
        query = "SELECT airline.name FROM AirlineEntity airline WHERE airline.airlineid IN (SELECT airport.airlineid FROM AirportAirline airport WHERE airport.airportid = :airportCode)"
)

@Entity
@Table(name = "contains")
public class AirportAirline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('contains_code_seq')")
    @Column(name = "code", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "airlineid", nullable = false)
    private String airlineid;

    @NotNull
    @Column(name = "airportid", nullable = false)
    private String airportid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(String airlineid) {
        this.airlineid = airlineid;
    }

    public String getAirportid() {
        return airportid;
    }

    public void setAirportid(String airportid) {
        this.airportid = airportid;
    }

}