package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@NamedQuery(
        name="AirlineEntity.getAirlineNameWithId",
        query="SELECT airline.name FROM AirlineEntity airline WHERE airline.airlineid = :airlineCode"
)

@Entity
@Table(name = "airlines")
public class AirlineEntity {
    @Id
    @Size(max = 3)
    @Column(name = "airlineid", nullable = false, length = 3)
    private String airlineid;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 3)
    @Column(name = "shortcode", length = 3)
    private String shortcode;

    public String getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(String airlineid) {
        this.airlineid = airlineid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

}