/**
 * <b>DOCUMENTATION FOR Class Application </b>
 * <br>
 * This class writes or overwrites a file set by the user with given text lines.
 * <br>
 * <b>+ setFlagRunning(Boolean) : void</b>
 * <br>
 * Sets true or false the static variable appRunning.
 * false stops the main loop.
 */

public class Application {

    public static boolean appRunning = true;
    public void launch() {

        // An object FileSystem is created. The FileSystem class contains methods to work with files.
        FileSystem fileSystem = new FileSystem();

        // Static class UI shows console messages.
        UI.displayWelcomeMessage();
        UI.displayFilePath();

        // This method sets the file path.
        fileSystem.setPath();

        // This method checks the file existance
        // If true, the app asks the user for overidding the file.
        if (fileSystem.checkExistence()){
            UI.displayFileExists();
            fileSystem.overwriteFile();
        }
        else
            UI.displayFileNoExists();


        // The console show the information to quit the program.
        UI.displayExitMessage();

        // Main Loop of the editing app
        while(appRunning) {
            boolean overwriteFile = FileSystem.getOverwriteFile();
            UI.displayInsertLine();
            fileSystem.createStringLine(overwriteFile);
        }
    }

    public static void setFlagRunning(boolean flag)
    {
        appRunning = flag;
    }
}
