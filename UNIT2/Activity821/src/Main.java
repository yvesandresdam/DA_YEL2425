import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Activity 8.2.1");
        System.out.println("Parsing a XML File");
        System.out.println(" ***** ");
        System.out.println();

        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse("contacts.xml", new XMLParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}