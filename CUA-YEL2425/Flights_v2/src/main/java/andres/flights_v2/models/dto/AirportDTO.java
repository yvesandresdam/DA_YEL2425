package andres.flights_v2.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AirportDTO {

    @NotBlank
    @Size(max = 4)
    private String code;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String city;

    public AirportDTO(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

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

    public void setCity(String city) {
        this.city = city;
    }
}

