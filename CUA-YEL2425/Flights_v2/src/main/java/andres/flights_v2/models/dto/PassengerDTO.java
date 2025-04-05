package andres.flights_v2.models.dto;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;

public class PassengerDTO {
//    @NotBlank(message = "El número de pasaporte es obligatorio")
//    @Size(min = 8, max = 8, message = "El número de pasaporte debe tener exactamente 8 caracteres")
    private String passportno;
    private String firstname;
    private String lastname;
    private String phone;
    private String sex;

    public PassengerDTO(String passportno, String firstname, String lastname, String phone, String sex) {
        this.passportno = passportno;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.sex = sex;
    }

    public String getPassportno() {
        return passportno;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }
}
