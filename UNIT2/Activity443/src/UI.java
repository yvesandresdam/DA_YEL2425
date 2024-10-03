import java.util.Scanner;

/**
 * DOCUMENTATION FOR CLASS UI
 * <br>
 * + _static_ displayFileType(FileType): void<br>
 * Displays information on the console
 * <br>
 * + _static_ UIGetFilePath(): String
 * <br>
 * The program asks the user for the filepath
 * <br>
 * + _static_ UIFileIsBMP(Boolean): void
 * <br>
 * Displays if the file is BMP
 *
 */
public class UI {
    public static void displayFileType(FileType fileType){
        System.out.println("The file is type: " + fileType);
    }

    public static String UIGetFilePath(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set the path of the file: ");
        String filePath = scanner.nextLine();
        scanner.close();

        return filePath;
    }

    public static void UIFileIsBMP(Boolean check){
        if(check)
            System.out.println("File is BMP type");
        else
            System.out.println("File is not BMP type");
    }
}
