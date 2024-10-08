import javax.tools.FileObject;
import java.io.*;
import java.net.URI;
import java.util.Scanner;

public class Application {

    // Debugging purposes 'filePath'
    private String resultFilePath = "resources/contacts.obj";
    private Agenda agenda = new Agenda();


    public void launch() {
        UI.UIWelcome();
        UI.UIMainPage();
        UI.UISelection();

        //loadAgenda();
        //userSelectOption();

        //Contact contact = agenda.createContact();
        //serializeContact(contact);

        viewAgenda();
    }

    private void viewAgenda() {
        try {
            ObjectInputStream view = new ObjectInputStream(new FileInputStream(resultFilePath));
            Contact contact = (Contact) view.readObject();
            System.out.println(contact.getName());
        } catch (IOException e1) {
            e1.getMessage();
        } catch (ClassNotFoundException e2){
            e2.getMessage();
        }



    }

    private void serializeContact(Contact contact) {
        try {
            ObjectOutputStream agendaWrite = new ObjectOutputStream(new FileOutputStream(resultFilePath));
            agendaWrite.writeObject(contact);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void loadAgenda() {
        try {
            ObjectInputStream agendaFile = new ObjectInputStream(new FileInputStream(resultFilePath));
            int numObjects = agendaFile.readInt();
            for (int i = 0; numObjects > 0; numObjects--) {
                Contact contact = (Contact) agendaFile.readObject();
            }
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ClassNotFoundException e2) {
            System.out.println("Error");
        }


    }

    private void userSelectOption() {
        Scanner scannerInput = new Scanner(System.in);
        String selection = scannerInput.next();

        switch (selection) {
            case "A":
                userAddContact();
                break;
            case "L":
                userListContact();
                break;
            case "F":
                userFindContact();
                break;
            default:
                System.out.println("Insert a valid option");
                break;
        }
        scannerInput.close();
    }

    private void userAddContact() {
        agenda.createContact();
    }

    private void userListContact() {

    }

    private void userFindContact() {

    }

}
