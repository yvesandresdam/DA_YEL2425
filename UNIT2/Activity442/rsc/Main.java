public class Main {
    public static void main(String[] args) {
        App application = new App();
        application.launch();
    }
}

/*
    DOCUMENTACION
    -------------


    ENUNCIADO
    -------------
    Write a program to detect the format of an image file. To detect the type of
    the file, the first bytes should be readed. Here you have a table with the header
    bytes for every format:

    .BMP:  42 4D
    .GIF:  47 49 46 38 39 61 / 37 61
    .JPEG: FF D8 FF
    .PNG:  89 50 4E 47
    .ICO:  00 00 01 00

 */
