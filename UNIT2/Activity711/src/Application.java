import javax.tools.FileObject;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    // Debugging purposes 'filePath'
    private String agendaFilePath = "resources/contacts.dat";
    private Agenda agenda = new Agenda();

    // This function launches the main Loop
    public void launch() {
        UI.UIWelcome();

        boolean running = true;
        while (running) {
            UI.UIMainPage();
            UI.UISelection();

            running = userSelectOption();
            if (!running)
                break;
        }
    }

    // PRIVATE FUNCTIONS
    private boolean userSelectOption() {
        boolean running = true;

        Scanner scannerInput = new Scanner(System.in);
        String selection = scannerInput.next();

        switch (selection) {
            case "A":
                Contact c = agenda.createContact();
                agenda.addContact(c);
                break;
            case "L":
                agenda.listAgenda();
                break;
            case "F":
                Contact c2 = agenda.findContactWithName();
                agenda.displayContact(c2);
                break;
            case "E":
                running = false;
                break;
            default:
                System.out.println("Insert a valid option");
                break;
        }
        return running;
    }

    private void serializeAgenda(){}
    private void deSerializeAgenda(){}





    /*
    private void serializeContact(List<Contact> listContacts) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(resultFilePath));

            //objectOutput.writeInt(2);
            for (Contact c : listContacts) {
                objectOutput.writeObject(c);
            }
            objectOutput.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    private void viewAgenda(List<Contact> listContacts) {
        try {
            ObjectInputStream displayAgenda = new ObjectInputStream(new FileInputStream(resultFilePath));
            //int numberCount = displayAgenda.readInt();

            int numberCount = listContacts.size();
            // Iterar sobre todos los contactos
            for (int i = 0; i < numberCount; i++) {
                Contact contact = (Contact) displayAgenda.readObject();
                //displayContact(contact);  // Mostrar el contacto
            }
        } catch (ClassNotFoundException |
                 IOException e) {
            e.printStackTrace();
        }
    }

     */
}
