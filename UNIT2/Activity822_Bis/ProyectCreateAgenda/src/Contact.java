import java.io.Serializable;
/**
 * DOCUMENTATION<br>
 * <b>Class Contact</b> contains the information of the agenda's contacts.
 */
public class Contact implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String description;

    public Contact(String name, String surname, String email, String phone, String description){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public Contact(){}


    // region GETters and SETters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // endregion
}
