public class Main {
    public static void main(String[] args) {
        System.out.println("Activities UNIT2");
    }
}

/*
    3.3. ACTIVITIES
    ---------------
    1. Write a java program that reads separately your name and surnames and
    welcomes you using your full name (“Hello, Jose Ramón García!”)

    2. Write a java program that reads a date, reading separately the day, the
    month and the year, and checking that the values for both month and day
    are correct (1...12, 1..31).

    3. Rewrite the previous activity creating a class (MyDate, for example). Use
    properties (setters) to check the values.

    4. Rewrite activity 3 to check the whole consistence of the date (not allowing
    February the 30th, for example), and informing the user if the year is a leap
    year (a leap year is a year with 366 days). The class created in activity 3
    must be extended.

    4.4. ACTIVITIES
    ---------------

    1. Rewrite the example above to read and write 128-bytes blocks instead of
    reading and writing a single byte.

    2. Write a program to detect the format of an image file. To detect the type of
    the file, the first bytes should be readed. Here you have a table with the header
    bytes for every format:

    File Type Header Bytes (Offset = 0)
    .BMP 42 4D
    .GIF 47 49 46 38 39 61 / 37 61
    .ICO 00 00 01 00
    .JPEG FF D8 FF
    .PNG 89 50 4E 47

    You can get more information about file headers here:
    https://en.wikipedia.org/wiki/List_of_file_signatures
    https://www.welivesecurity.com/la-es/2015/10/01/extension-de-un-archivocabeceras/

    3. Write a program to read the header of a BMP file and report its size, width,
    height and if the bits per pixel. You must read the reader as a block.

    Here you can get more information about the BMP header:
    http://www.fastgraph.com/help/bmp_header_format.html

    4. Write the test class (using JUnit) for program 4.4.3.


    5.4. ACTIVITIES
    ---------------

    1. Write a program to create a notepad. The program will ask for sentences
    to the user and write it to a file. The file can exist or not, if it does, the user
    should be asked whether to overwrite the information or append it. Lines
    will be numbered sequentially. You may need to read point 6 first.

    2. Write a program to sort alphabetically two files previously sorted (the
    name of the files will be provided by the user). The destination file will be
    “sorted.txt”.

    For example, if the file 1 contains the lines:
    Car
    Horse
    Ship

    And the file 2 contains:
    Alley
    Cat
    Horn
    Show
    Tree

    The file “sorted.txt” will contain:
    Alley
    Car
    Cat
    Horn
    Horse
    Ship
    Show
    Tree

    3. Write a program to show the content of the file created in the exercise one
    (or any other file) on the screen. The program must stop every 23 lines,
    awaiting for the user to press ‘space’ (or newline, or any other key) in order
    to allow the whole content of the file to be readed.

    4. Write a program to search for a string inside a file text. It must print out
    every line containing the string, indicating the line number. File existence
    must be controlled.

    7.1. ACTIVITIES
    ---------------

    1. Write a program to create a contact list. First of all, you will need a class
    Contact, with the following information: name, surname, e-mail, phone
    number, description. The program must permit to create new contacts,
    show the current list of contacts and search for a contact by its full name
    or phone. Data must be stored and retrieved in a file named contacts.obj.
    If it doesn’t exist, it must be created.

    8.2. ACTIVITIES
    ---------------

    1. Rewrite the previous code just to show the name and surname of the
    contacts (all together) with a phone number. The phone number will be
    chosen in this order: cell, work, home.

    2. Write an utility to allow the user to change the format of the file created in
    activity 7.1 from obj to XML and reverse. Check point 9 to know how to
    reuse your code. You can use this link as a guide:
    https://zetcode.com/java/sax/

    10. BIBLIOGRAPHY
    ---------------

    https://www.jetbrains.com/help/idea/discover-intellij-idea.html
    https://docs.oracle.com/en/java/javase/16/docs/api/index.html
    https://www.javatpoint.com/java-tutorial
    https://zetcode.com/all/#java
    
 */