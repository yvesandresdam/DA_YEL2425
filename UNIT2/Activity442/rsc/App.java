import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public void launch() {
        UI.displaySplashScreen();

        String path = UI.getImagePath();
        FileType fileResult = imageFormatDetection(path);

        UI.displayResult(fileResult);
        UI.displayExitMessage();
    }

    public FileType imageFormatDetection(String path) {
        // A efectos de Debugging
        // String pathDebugger = "images/imagenICO.ico";

        FileInputStream fileStream;
        byte[] buffer = new byte[6];

        try {
            fileStream = new FileInputStream(path);
            fileStream.read(buffer);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            System.out.println("Error en el input");
        }

        return analyzeBytes(buffer);
    }

    private FileType analyzeBytes(byte[] buffer) {
        if (buffer[0] == 0x42 && buffer[1] == 0x4D)
            return FileType.BMP;

        if (buffer[0] == 0x00 && buffer[1] == 0x00 &&
                buffer[2] == 0x01 && buffer[3] == 0x00)
            return FileType.ICO;

        // Aquí surge el problema del byte con signo no reconocible por JAVA
        // Se puede utilizar la funcion de la clase Byte que cambia un byte a un entero SIN signo
        int byte1 = Byte.toUnsignedInt(buffer[0]);
        int byte2 = Byte.toUnsignedInt(buffer[1]);
        int byte3 = Byte.toUnsignedInt(buffer[2]);

        if (byte1 == 0xFF && byte2 == 0xD8 &&
                byte3 == 0xFF)
            return FileType.JPG;

        // Aqui se resuelve el problema con un casting implicito a (byte)
        if (buffer[0] == (byte)0x89 && buffer[1] == (byte)0x50 &&
                buffer[2] == (byte)0x4E && buffer[3] == (byte)0x47)
            return FileType.PNG;

        if (buffer[0] == 0x47 && buffer[1] == 0x49 &&
                buffer[2] == 0x46 && buffer[3] == 0x38 &&
                buffer[4] == 0x39 && buffer[5] == 0x61)
            return FileType.GIF;

        if (buffer[0] == 0x47 && buffer[1] == 0x49 &&
                buffer[2] == 0x46 && buffer[3] == 0x38 &&
                buffer[4] == 0x37 && buffer[5] == 0x61)
            return FileType.GIF;

        return FileType.UNKNOWN;
    }
}

/*
    DOCUMENTACION
    -------------
 */
