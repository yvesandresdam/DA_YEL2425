import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to XML_Parser");
        CoreApp core = new CoreApp();


        core.createNewXML();
        core.createXMLFile("XMLTesting1.xml");


        System.out.println("Press a key to exit...");
        Scanner quitProgram = new Scanner(System.in);
        quitProgram.nextLine();
    }
}
