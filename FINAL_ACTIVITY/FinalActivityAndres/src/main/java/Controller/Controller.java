package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

    // DEV: Controller Class
    // The Controller class brings perfect communications between Model and View.
    // The Controller class gets bridges between Model and View.


    // DEV: design of the application MainFrame - launchApp Pattern
    // + startApp: SplashScreen and Welcome Message
    // + loginPattern: userName, userPassword, login Succeded o failed
    // + mainWindowUser: preferences and personal data


    public void launchApp() {

        connectingDatabase();
        // CONNECTING THE POSTGRES DATABASE

        startApp();
        // SPLASH AND WELCOME MESSAGE

        while (!userGranted) {
            loginPattern();
        }
        // SUCESFULL LOGIN WITH USER/PASSWORD

        mainWindowUser();
        // USER DATA INFORMATION WINDOW
    }

    // ATRIBUTES
    private boolean userGranted = true;
    private LoginPattern login;


    // WIREFRAME FUNCTIONS
    private void connectingDatabase() {
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.setConnection("OnlineMarket", "postgres", "postgres");
        connectionDB.startConnection();
    }

    private void startApp() {

    }

    private void loginPattern() {
        login.mainLoopLogin();
    }

    private void mainWindowUser() {
        displayUserData();
        // Display user data

        changePersonalData();
        // Modify user data

        backToLogin();
        // Login with another username

        quitApplication();
        // Exit the application
    }


    // PRIVATE FUNCTIONS

    private void displayUserData() {

    }

    private void changePersonalData() {
        changeUserName();
        changeUserPassword();
        changeBussinessName();
        changePhone();
        changeEmail();
        // MODIFY USER INFORMATION
    }

    private void changeEmail() {
    }

    private void changePhone() {
    }

    private void changeBussinessName() {
    }

    private void changeUserPassword() {
    }

    private void changeUserName() {
    }

    private void backToLogin() {
    }

    private void quitApplication() {
    }
}

/*
    DOCUMENTATION
    -------------

    DEV: This class is the mainFrame of the application.

    + void connectingDatabase: performs connection to database.
    + void startApp: displays the SplashScreen and the WelcomeMessage.
    + void loginPattern: controls the right access of the user.
    + void mainWindowUser: displays the data information. Allows user to change preferences.

*/
