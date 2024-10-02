import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Application {

    // Debugging purposes 'filePath'
    private String filePath = "resources/contacts.obj";
    private Reader fileRead = FileReader.nullReader();

    public void launch(){
        readFile();
        displayFileContent();
    }

    private void readFile(){
        try {
            fileRead = new FileReader(filePath);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    private void displayFileContent(){
        try {
            int n = 0;
            while(n != -1) {
                n = fileRead.read();
                System.out.print((char)n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
