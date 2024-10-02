import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contact> contactList = new ArrayList();

    public void addContact(Contact contact){
        if(contact == null)
            return;
        contactList.add(contact);
    }

    public void displayContactList(){
        for(Contact c : contactList){
            System.out.println(c);
        }
    }
}
