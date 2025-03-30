package andres.flights_v2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")
public class AirportEntity {
    @Id
    @Column(name = "code", nullable = false, length = 4)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "city", nullable = false)
//    private CityEntity city;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

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

    public String getCity() {
        return city;
    }

    public void String(String city) {
        this.city = city;
    }

}