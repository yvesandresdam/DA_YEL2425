import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public void launch(){
        Scanner scInput = new Scanner(System.in);

        // Se guarda en una variable la ruta del archivo 1
        System.out.println(LanguageDistribution.RUTA_DEL_ARCHIVO1);
        String firsPath = scInput.nextLine();
        firsPath = "resources/Texto1.txt";

        // Se guarda en una variable la ruta del archivo 2
        System.out.println(LanguageDistribution.RUTA_DEL_ARCHIVO2);
        String secondPath = scInput.nextLine();
        secondPath = "resources/Texto2.txt";

        BufferedReader firstFile = null;
        BufferedReader secondFile = null;
        try {
            firstFile = new BufferedReader(new FileReader(firsPath));
            secondFile = new BufferedReader(new FileReader(secondPath));
        }catch (FileNotFoundException nf){
            System.out.println("Error");
        }

        int result = 0;
        try{
            result = firstFile.read();
        } catch(IOException ie){
            System.out.println("Error");
        }
        System.out.println(firstFile);
    }
}
