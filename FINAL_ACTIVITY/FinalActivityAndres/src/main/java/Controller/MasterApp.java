package Controller;

public class MasterApp {

    // DEV: The single utility of this class is to launch the main Controller
    // TODO: Singleton

    // private static MasterApp singleton;
    private Controller controller;

    public void launchController() {
        controller = new Controller();
        controller.launchApp();
    }
}

/*
    DOCUMENTATION
    -------------

    DEV: This class contains the controller instance .
    Launches the main loop of the Controller.

*/
