package andres.flights_v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa un aeropuerto en la base de datos.
 *
 * Esta entidad está mapeada a la tabla "airports".
 * Cada aeropuerto tiene un código único y un nombre.
 */
@Entity
@Table(name = "airports")
public class AirportEntity {

    /**
     * Código identificador del aeropuerto (por ejemplo: "JFK").
     * Es la clave primaria de la tabla.
     * Tiene una longitud máxima de 4 caracteres y no puede estar vacío.
     */
    @Id
    @NotBlank
    @Size(max = 4)
    @Column(name = "code", nullable = false, length = 4)
    private String code;

    /**
     * Nombre del aeropuerto (por ejemplo: "John F. Kennedy International Airport").
     * Tiene una longitud máxima de 100 caracteres y no puede estar vacío.
     */
    @Size(max = 100)
    @NotBlank
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Devuelve el código del aeropuerto.
     *
     * @return código del aeropuerto
     */
    public String getCode() {
        return code;
    }

    /**
     * Establece el código del aeropuerto.
     *
     * @param code nuevo código del aeropuerto
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Devuelve el nombre del aeropuerto.
     *
     * @return nombre del aeropuerto
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del aeropuerto.
     *
     * @param name nuevo nombre del aeropuerto
     */
    public void setName(String name) {
        this.name = name;
    }
}
