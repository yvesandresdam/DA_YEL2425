import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DOCUMENTATION FOR CLASS TypeFinder
 * <br>
 * + _static_ FileWork(): void
 * <br>
 * Works with file and UI classes
 * <br>
 * + getFileType(byte[]): FileType
 * <br>
 * Returns the file type of the file
 *
 */
public class TypeFinder {

    public static void FileWork() {
        String path = UI.UIGetFilePath();

        // Debugging purposes
        path = "images/imagen1.bmp";
        path = "images/imagenJPG.jpg";

        try {
            FileInputStream fileInput = new FileInputStream(path);

            byte[] buffer54Bytes = new byte[54];
            int valueReaded = fileInput.read(buffer54Bytes);

            FileType fileType = getFileType(buffer54Bytes);

            Boolean check = fileType == FileType.BMP ? true : false;
            UI.UIFileIsBMP(check);

        } catch (FileNotFoundException f) {
            System.out.println("Error");
        } catch (IOException io) {
            System.out.println("Error");
        }
    }

    private static FileType getFileType(byte[] buffer) {
        byte header1 = buffer[0];
        byte header2 = buffer[1];

        if ((header1 == 0x42) && (header2 == 0x4D))
            return FileType.BMP;
        return FileType.UNKNOWN;
    }

    private static int getFileSize(byte[] buffer) {
        String value = "";
        int number;
        for (byte b : buffer) {
            number = (int) b;
            value += Integer.toHexString(number & 0xFF);
        }
        System.out.println(value);
        getSize(buffer);
        return 1;
    }

    private static byte[] getBytesWithOffset(int offset, int numberBytes, byte[] buffer) {
        byte[] result = new byte[numberBytes];
        for (int i = offset; i < numberBytes; i++) {
            //addByteToArray(result, buffer[i]);
        }
        return result;
    }

    private static void getSize(byte[] buffer) {
        return;
    }
}