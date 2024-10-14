import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class WorkingFiles {


    public void displayObjectFile(String path){
        try {
            ObjectInputStream fileAgenda = new ObjectInputStream(new FileInputStream(path));
            if (fileAgenda != null) {
               int numberContacts = fileAgenda.readInt();
                for (int i = 0; i < numberContacts; i++) {
                    Contact c = (Contact) fileAgenda.readObject();
                    System.out.println(c.getName());
                    System.out.println(c.getSurname());
                    System.out.println(c.getPhone());
                    System.out.println(c.getEmail());
                    System.out.println(c.getDescription());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.fillInStackTrace();
        }
    }
}
