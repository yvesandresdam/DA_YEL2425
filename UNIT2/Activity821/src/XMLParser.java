import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
    protected String tagContent;
    private String currentElement = "";

    // Opening TAG
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
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
        if (qName.equals("home")) {
            System.out.println("Home: " + tagContent); // Imprimir solo el contenido de home
        } else if (qName.equals("cell")) {
            System.out.println("Cell: " + tagContent);
        } else {
            System.out.println("Work: " + tagContent);
        }
            // Reiniciar el contenido para la siguiente etiqueta
            tagContent = "";
            currentElement = "";
        }
    }
