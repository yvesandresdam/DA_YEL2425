package andres.flights_v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Representa un pasajero dentro del sistema de vuelos.
 *
 * Esta clase está mapeada a la tabla "passengers" de la base de datos
 * y contiene la información personal básica necesaria para emitir un ticket.
 */
@Entity
@Table(name = "passengers")
public class PassengerEntity {

    /**
     * Número de pasaporte del pasajero.
     * Es la clave primaria de la tabla.
     * Debe comenzar por una letra seguida de 7 dígitos numéricos.
     */
    @Id
    @Size(max = 10)
    @Pattern(regexp = "^[A-Za-z][0-9]{7}$", message = "Passport must start with a letter followed by 7 numbers")
    @Column(name = "passportno", nullable = false, length = 10)
    private String passportno;

    /**
     * Nombre del pasajero.
     * No puede estar vacío y debe tener un máximo de 20 caracteres.
     */
    @Size(max = 20)
    @NotBlank(message = "Name cannot be empty")
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstname;

    /**
     * Apellido del pasajero.
     * No puede estar vacío y debe tener un máximo de 20 caracteres.
     */
    @Size(max = 20)
    @NotBlank(message = "Last name cannot be empty")
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastname;

    /**
     * Dirección del pasajero (opcional).
     */
    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    /**
     * Teléfono del pasajero (opcional).
     * Si se proporciona, debe empezar por +34 y tener 9 dígitos adicionales.
     */
    @Size(max = 12)
    @Pattern(regexp = "(^$)|(^\\+34\\d{9}$)", message = "Phone number must start with +34 and a 9 characters length")
    @Column(name = "phone", length = 12)
    private String phone;

    /**
     * Sexo del pasajero.
     * Debe ser 'M' (masculino) o 'F' (femenino).
     */
    @Size(max = 1)
    @Pattern(regexp = "^[MF]$", message = "Sex must be 'M' or 'F'")
    @Column(name = "sex", length = 1)
    private String sex;

    // Getters y setters

    /** @return número de pasaporte */
    public String getPassportno() {
        return passportno;
    }

    /** @param passportno nuevo número de pasaporte */
    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    /** @return nombre del pasajero */
    public String getFirstname() {
        return firstname;
    }

    /** @param firstname nuevo nombre del pasajero */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /** @return apellido del pasajero */
    public String getLastname() {
        return lastname;
    }

    /** @param lastname nuevo apellido del pasajero */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /** @return dirección del pasajero */
    public String getAddress() {
        return address;
    }

    /** @param address nueva dirección del pasajero */
    public void setAddress(String address) {
        this.address = address;
    }

    /** @return número de teléfono */
    public String getPhone() {
        return phone;
    }

    /** @param phone nuevo número de teléfono */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** @return sexo del pasajero */
    public String getSex() {
        return sex;
    }

    /** @param sex nuevo sexo del pasajero */
    public void setSex(String sex) {
        this.sex = sex;
    }
}
