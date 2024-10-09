public class Main {
    public static void main(String[] args) {
        System.out.println("Activity 7.1.1");
        System.out.println("Welcome to your agenda contacts JAVAaPP");

        Application app = new Application();
        app.launch();
    }
}

/*
    DOCUMENTATION
    -------------

    Write a program to create a contact list. First of all, you will need a class
    Contact, with the following information: name, surname, e-mail, phone
    number, description. The program must permit to create new contacts,
    show the current list of contacts and search for a contact by its full name
    or phone. Data must be stored and retrieved in a file named 'contacts.obj'.
    If it doesn’t exist, it must be created.
 */