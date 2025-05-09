package andres.flights_jfxtemplate.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerDTO {

    private String firstname;
    private String lastname;
    private String passportno;
    private String address;
    private String phone;
    private String sex;

    // Constructor vacío (requerido para Jackson)
    public PassengerDTO() {
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("passportno")
    public String getPassportno() {
        return passportno;
    }

    @JsonProperty("passportno")
    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(String sex) {
        this.sex = sex;
    }
}
