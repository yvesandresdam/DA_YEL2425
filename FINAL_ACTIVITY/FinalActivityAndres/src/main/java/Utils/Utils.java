package Utils;

import java.util.Scanner;

public class Utils {

    public static void exitApplication(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any key to exit..");
        scanner.nextLine();
    }

    public static String userTextInput(){
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }
}
