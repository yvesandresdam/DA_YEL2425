import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * DOCUMENTACION<br>
 * <b>Class Agenda</b> contains a List of contacts.<br>
 * also CRUD operations with the List of contacts.
 */
public class Agenda {
    private List<Contact> contactList = new ArrayList<>();

    public Contact createContact() {
        Scanner scannerInput = new Scanner(System.in);

        UI.UISetName();
        String name = scannerInput.nextLine();

        UI.UISetSurname();
        String surname = scannerInput.nextLine();

        UI.UISetEmail();
        String email = scannerInput.nextLine();

        UI.UISetPhone();
        String phone = scannerInput.nextLine();

        UI.UISetDescription();
        String description = scannerInput.nextLine();


        // CREAR UN CONTACTO NUEVO

        // METODO 1. EL CONSTRUCTOR
        // Contact contact = new Contact(name,surname,email,phone,description);
        // addContact(contact);

        // METODO 2. SETTERS
        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setDescription(description);
        return contact;
    }

    public void addContact(Contact contact) {
        if (contact == null)
            return;
        contactList.add(contact);
    }

    public void listAgenda() {
        for (Contact contact : contactList) {
            System.out.printf("Name: %s\nSurname: %s\n", contact.getName(), contact.getSurname());
            System.out.printf("Phone: %s\nEmail: %s\nDescription: %s\n\n", contact.getPhone(), contact.getEmail(), contact.getDescription());
            System.out.println(" * * * * * ");
        }
    }

    public Contact findContactWithName() {
        Scanner scannerInput = new Scanner(System.in);
        String name = scannerInput.nextLine();
        for (Contact contact : contactList) {
            if (contact.getName().equals(name))
                return contact;
        }
        return null;
    }

    public void displayContact(Contact contact){
        System.out.printf("Name: %s\nSurname: %s\n", contact.getName(), contact.getSurname());
        System.out.printf("Phone: %s\nEmail: %s\nDescription: %s\n", contact.getPhone(), contact.getEmail(), contact.getDescription());
        System.out.println(" * * * * * ");
    }

    public int getAgendaSize(){
        return contactList.size();
    }

    public Contact getContactAt(int position){
        return contactList.get(position);
    }
}
