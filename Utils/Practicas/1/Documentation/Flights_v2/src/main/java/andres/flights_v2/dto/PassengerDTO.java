package andres.flights_v2.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * DTO para representar datos de un pasajero.
 *
 * Incluye validaciones para los campos más importantes:
 * pasaporte, nombre, apellido, teléfono y sexo.
 */
public class PassengerDTO {

    /**
     * Número de pasaporte del pasajero.
     * Debe comenzar con una letra seguida de 7 números (total 8 caracteres).
     */
    @Id
    @Size(max = 9)
    @Pattern(regexp = "^[A-Za-z][0-9]{7}$", message = "Passport must start with a letter followed by 7 numbers")
    @NotBlank(message = "Passport cannot be empty")
    private String passportno;

    /**
     * Nombre del pasajero.
     */
    @Size(max = 20)
    @NotBlank(message = "Name cannot be empty")
    private String firstname;

    /**
     * Apellido del pasajero.
     */
    @Size(max = 20)
    @NotBlank(message = "Last name cannot be empty")
    private String lastname;

    /**
     * Dirección postal del pasajero (opcional).
     */
    @Size(max = 100)
    private String address;

    /**
     * Teléfono del pasajero, con formato +34 y 9 dígitos (opcional).
     */
    @Size(max = 12)
    @Pattern(regexp = "(^$)|(^\\+34\\d{9}$)", message = "Phone number must start with +34 and a 9 characters length")
    private String phone;

    /**
     * Sexo del pasajero, 'M' o 'F'.
     */
    @Size(max = 1)
    @NotBlank(message = "Sex cannot be blank")
    @Pattern(regexp = "^[MF]$", message = "Sex must be 'M' or 'F'")
    private String sex;

    /**
     * Constructor por defecto.
     */
    public PassengerDTO() {}

    /**
     * Constructor completo con todos los campos.
     *
     * @param passportno número de pasaporte
     * @param firstname nombre
     * @param lastname apellido
     * @param address dirección
     * @param phone teléfono
     * @param sex sexo
     */
    public PassengerDTO(String passportno, String firstname, String lastname, String address, String phone, String sex) {
        this.passportno = passportno;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
    }

    // Getters y Setters

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
