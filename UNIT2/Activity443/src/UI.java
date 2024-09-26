import java.util.Scanner;

public class UI {
    public static void DisplayFileType(FileType fileType){
        System.out.println("El archivo es de tipo: " + fileType);
    }

    public static String UIGetFilePath(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la ruta del archivo BMP: ");
        String filePath = scanner.nextLine();
        scanner.close();

        return filePath;
    }

    public static void UIFileIsBMP(Boolean check){
        if(check)
            System.out.println("El archivo es de tipo BMP");
        else
            System.out.println("El archivo no es de tipo BMP");
    }
}
