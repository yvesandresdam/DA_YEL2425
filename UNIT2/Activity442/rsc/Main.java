public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 4.4.2");
        System.out.println("Reconocer el formato de imagen");

        App application = new App();
        application.getFirstBytes();
    }
}

/*
    EXERCISE 4.4.2
    --------------
    Write a program to detect the format of an image file. To detect the type of
    the file, the first bytes should be readed. Here you have a table with the header
    bytes for every format:
 */
