import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 4.4.2");

        Scanner scanner = new Scanner(System.in);

        try {
            FileInputStream fileStream = new FileInputStream("images/imagenJPG.jpg");
            byte[] byte6 = new byte[6];
            int test = fileStream.read(byte6);
            int hexadecimal = 0x30;
            System.out.println(test);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}

/*
    Write a program to detect the format of an image file. To detect the type of
    the file, the first bytes should be readed. Here you have a table with the header
    bytes for every format:
 */
