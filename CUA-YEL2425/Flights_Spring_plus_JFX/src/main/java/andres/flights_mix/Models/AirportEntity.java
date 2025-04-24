package andres.flights_mix.Models;

import jakarta.persistence.*;

@NamedQuery(
        name = "AirportEntity.findAllNames",
        query = "SELECT DISTINCT f.name FROM AirportEntity f"
)

@Entity
@Table(name = "airports")
public class AirportEntity {
    @Id
    @Column(name = "code", nullable = false, length = 4)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}