import java.io.FileWriter;
import java.io.IOException;

public class CoreApp {
    private String XMLresultFile = "";

    public void createNewXML(){
        String root = "Students";
        String tagStudent = "Student";
        String tagStudentName = "Name";
        String name1 = "Portos";
        String name2 = "Aramis";
        String name3 = "Athos";

        XMLCreator xmlCreator = new XMLCreator();
        // ROOT Tag
        String result = xmlCreator.createOpenTagWithTitle(root);

        // Student 1
        result += xmlCreator.createOpenTagWithTitle(tagStudent);
        result += xmlCreator.createOpenTagWithTitle(tagStudentName);
        result += name1;
        result += xmlCreator.createCloseTagWithTitle(tagStudentName);
        result += xmlCreator.createCloseTagWithTitle(tagStudent);

        // Student 2
        result += xmlCreator.createOpenTagWithTitle(tagStudent);
        result += xmlCreator.createOpenTagWithTitle(tagStudentName);
        result += name2;
        result += xmlCreator.createCloseTagWithTitle(tagStudentName);
        result += xmlCreator.createCloseTagWithTitle(tagStudent);

        // Student 3
        result += xmlCreator.createOpenTagWithTitle(tagStudent);
        result += xmlCreator.createOpenTagWithTitle(tagStudentName);
        result += name3;
        result += xmlCreator.createCloseTagWithTitle(tagStudentName);
        result += xmlCreator.createCloseTagWithTitle(tagStudent);

        // CLOSING Tags
        result += xmlCreator.createCloseTagWithTitle(root);

        XMLresultFile = result;
    }

    public void createXMLFile(String path){
        try{
            FileWriter file = new FileWriter(path);
            file.write(XMLresultFile);
            file.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
