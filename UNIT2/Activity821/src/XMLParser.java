import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
    protected String tagContent;

    // Opening TAG
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("contact")) {
            System.out.println("ID: " + attributes.getValue("id"));
        }
    }

    // Content TAG
    public void characters(char ch[], int start, int length) throws SAXException {
        tagContent = new String(ch, start, length);
    }

    // Ending TAG
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!qName.isBlank()) {
            if (!qName.equals("contact")) {
                System.out.println(" " + qName + ": " + tagContent);
            }
        }
    }
}
