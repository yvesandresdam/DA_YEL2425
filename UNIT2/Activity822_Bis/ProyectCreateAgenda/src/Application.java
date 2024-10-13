import java.io.*;
import java.util.Scanner;

public class Application {

    // Debugging purposes 'agendaPath'
    private String agendaPath = "resources/contacts.dat";
    private Agenda agenda = new Agenda();

    // This function launches the main Loop
    public void launch() {
        welcomeMessage();
        deSerializeAgenda();

        {   // main Loop of the aplication
            boolean running = true;
            while (running) {
                displayMainPage();
                running = userSelectOption();
                if (!running)
                    break;
            }
        }

        serializeAgenda();
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

    private void deSerializeAgenda() {
        try {
            ObjectInputStream fileAgenda = new ObjectInputStream(new FileInputStream(agendaPath));
            if (fileAgenda != null) {
                int numberContacts = fileAgenda.readInt();
                for (int i = 0; i < numberContacts; i++) {
                    Contact c = (Contact) fileAgenda.readObject();
                    agenda.addContact(c);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.fillInStackTrace();
        }
    }

    private void serializeAgenda() {
        try {
            ObjectOutputStream outputAgenda = new ObjectOutputStream(new FileOutputStream(agendaPath));
            int numberContacts = agenda.getAgendaSize();
            outputAgenda.writeInt(numberContacts);
            for (int i = 0; i < numberContacts; i++) {
                Contact c = agenda.getContactAt(i);
                outputAgenda.writeObject(c);
            }
            outputAgenda.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void welcomeMessage() {
        UI.UIWelcome();
    }

    private void displayMainPage() {
        UI.UIMainPage();
        UI.UISelection();
    }
}
