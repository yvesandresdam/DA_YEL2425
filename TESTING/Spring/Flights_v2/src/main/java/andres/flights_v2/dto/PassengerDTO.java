package andres.flights_v2.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PassengerDTO {

    @Id
    @Size(max = 9)
    @Pattern(regexp = "^[A-Za-z][0-9]{7}$", message = "Passport must start with a letter followed by 7 numbers")
    @NotBlank(message = "Passport cannot be empty")
    private String passportno;

    @Size(max = 20)
    @NotBlank(message = "Name cannot be empty")
    private String firstname;

    @Size(max = 20)
    @NotBlank(message = "Last name cannot be empty")
    private String lastname;

    @Size(max = 100)
    private String address;

    @Size(max = 12)
    @Pattern(regexp = "(^$)|(^\\+34\\d{9}$)", message = "Phone number must start with +34 and a 9 characters length")
    private String phone;

    @Size(max = 1)
    @NotBlank(message = "Sex cannot be blank")
    @Pattern(regexp = "^[MF]$", message = "Sex must be 'M' or 'F'")
    private String sex;

    public PassengerDTO(){};

    public PassengerDTO(String passportno, String firstname, String lastname, String address, String phone, String sex) {
        this.passportno = passportno;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
    }

    // _getters / setters_
    public String getPassportno() {
        return passportno;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
