import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    private static String filePath;
    private BufferedReader fileRead = null;
    private byte[] contents = new byte[50];

    public void launch() {
        // Pide al usuario la ruta del archivo
        UI.displayFilePath();

        // Guarda la ruta del archivo
        storeFilePath();

        // Operaciones con archivos
        readFilePath();

        getFileRead();

    }

    private void storeFilePath() {
        Scanner scInput = new Scanner(System.in);
        filePath = scInput.nextLine();
        filePath = "resources/testing.txt";

        scInput.close();
    }

    private void readFilePath() {
        try {
            fileRead = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    private void getFileRead() {
        try {
            String textLine = fileRead.readLine();
            int numberLine = 0;
            while(numberLine < 23){
                System.out.println(textLine);
                textLine = fileRead.readLine();
                if(textLine == null)
                    break;
                numberLine++;
            }
            fileRead.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
