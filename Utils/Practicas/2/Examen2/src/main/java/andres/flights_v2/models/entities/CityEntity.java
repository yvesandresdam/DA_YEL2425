package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


// TODO                                                    ■ CLASE CITY
//                                                         ■ Contiene la tabla ciudad

@NamedQueries({
        @NamedQuery(
                name = "CityEntity.getCityWithCode",
                query = "SELECT city FROM CityEntity city WHERE city.code = :codigoCiudad"
        ),
        @NamedQuery(
                name = "CityEntity.getAllCities",
                query = "SELECT city FROM CityEntity city"
        )})

@Entity
@Table(name = "cities")
public class CityEntity {
    @Id
    @Size(max = 3)
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Size(max = 15)
    @NotNull
    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Size(max = 15)
    @NotNull
    @Column(name = "state", nullable = false, length = 15)
    private String state;

    @Size(max = 30)
    @NotNull
    @Column(name = "country", nullable = false, length = 30)
    private String country;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}