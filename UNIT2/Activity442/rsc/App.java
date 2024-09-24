import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public void getFirstBytes() {
        try {
            FileInputStream fileStream = new FileInputStream("images/imagenJPG.jpg");
            byte[] buffer = new byte[6];

            // La funcion read() almacena en el buffer que le pasamos por
            // parametros el contenido del objeto FileStream
            // Devuelve el numero de bytes leidos correctamente
            // -1 si ha llegado al final del documento.
            int numberBytesReaded = fileStream.read(buffer);

            // Podemos recorrer el buffer con un bucle para leer
            // los valores almacenados en su interior
            for(byte b : buffer)
            {
                // Impresion por pantalla del numero en decimal
                int decimalValue = (int)b;
                System.out.print("Valor en decimal: ");
                System.out.println(decimalValue);

                // Impresion por pantalla del numero en hexadecimal
                String hexadecimalValue = Integer.toHexString(decimalValue & 0xFF);
                System.out.print("Valor en hexadecimal: ");
                System.out.println(hexadecimalValue);
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
