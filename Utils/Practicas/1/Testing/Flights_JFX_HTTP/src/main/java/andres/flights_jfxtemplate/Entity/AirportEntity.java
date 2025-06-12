package andres.flights_jfxtemplate.Entity;

public class AirportEntity {
    private String code;
    private String name;

    public AirportEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}

