import java.util.Scanner;

public class UI {
    public static void displaySplashScreen() {
        System.out.println("Ejercicio 4.4.2");
        System.out.println("Programa de reconocimiento de formato de imagen.\n");
    }

    public static String getImagePath() {
        String path;
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("Introduzca la ruta de la imagen: ");
        path = scannerInput.next();
        return path;
    }

    public static void displayResult(FileType fileResult) {
        if (fileResult == FileType.UNKNOWN)
            System.out.println("El archivo es de tipo desconocido" + "\n");
        System.out.println("El archivo es de tipo: " + fileResult.name()+ "\n");
    }

    public static void displayExitMessage(){
        System.out.println("Gracias por usar nuestro software.");
    }
}
