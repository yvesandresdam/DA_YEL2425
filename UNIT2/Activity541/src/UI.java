import java.util.Scanner;

public class UI {
    public static void displayWelcomeMessage() {
        System.out.println("Bienvenido a su aplicacion de texto JavaNOTE");
    }

    public static void displayFilePath(){
        System.out.println("Establezca la ruta de su archivo");
    }

    public static void displayFileExists(){
        System.out.println("El archivo ya existe");
    }
    public static void displayFileNoExists(){
        System.out.println("El archivo no existe");
        System.out.println("Se creará un archivo nuevo");
    }

    public static void displayExitMessage(){
        System.out.println("Introduzca la palabra 'exit' para salir");
    }
    public static void displayInsertLine() {
        System.out.println("Introduzca la linea de texto");
    }
}
