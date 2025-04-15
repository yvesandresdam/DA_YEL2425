package andres.flights_v2.dto;

public class PassengerDTO {
    private String passportno;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
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
