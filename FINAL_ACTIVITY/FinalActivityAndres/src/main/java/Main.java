import Controller.MasterApp;
import Utils.Utils;

public class Main {
    public static void main(String[] args) {

        // DEV: Launching the main Controller
        // ----------------------------------

        MasterApp master = new MasterApp();
        master.launchController();

        Utils.exitApplication();
    }
}

/*
    DOCUMENTATION
    -------------

    This class launchs the main application
    MasterApp can be the Singleton of the application

    _static_ exitApplication() waits the user to quit the application

*/

