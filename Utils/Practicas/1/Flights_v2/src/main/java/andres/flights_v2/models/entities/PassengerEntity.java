package andres.flights_v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "passengers")
public class PassengerEntity {
    @Id
    @Size(max = 10)
    @Pattern(regexp = "^[A-Za-z][0-9]{7}$", message = "Passport must start with a letter followed by 7 numbers")
    @Column(name = "passportno", nullable = false, length = 10)
    private String passportno;

    @Size(max = 20)
    @NotBlank(message = "Name cannot be empty")
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstname;

    @Size(max = 20)
    @NotBlank(message = "Last name cannot be empty")
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastname;

    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    @Size(max = 12)
    @Pattern(regexp = "(^$)|(^\\+34\\d{9}$)", message = "Phone number must start with +34 and a 9 characters length")
    @Column(name = "phone", length = 12)
    private String phone;

    @Size(max = 1)
    @Pattern(regexp = "^[MF]$", message = "Sex must be 'M' or 'F'")
    @Column(name = "sex", length = 1)
    private String sex;

    // _getters / setters_

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