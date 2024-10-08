import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        scannerInput.close();

        // AÑADIR CONTACTO A LA LISTA

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

    public void displayContactList() {
        int i = 0;
        for (Contact contact : contactList) {
            i++;
            System.out.printf("Contact number: %d\nName: %s\nSurname: %s\n", i, contact.getName(), contact.getSurname());
            System.out.printf("Phone: %s\nEmail: %s\nDescription: %s\n", contact.getPhone(), contact.getEmail(), contact.getDescription());
        }
    }

    public Contact findContactWithName(String name) {
        for (Contact contact : contactList) {
            if(contact.getName().equals(name))
                return contact;
        }
        return null;
    }
}
