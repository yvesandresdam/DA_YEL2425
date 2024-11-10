package Controller;

import View.View;
import Utils.Utils;

public class LoginPattern {

    // DEV: Login Pattern
    // Algorithm of User Access to the application
    // A valid username is needed
    // That username must match the MD5 password stored in the Database

    // ATRIBUTOS
    private String userName;
    private String userPassword;
    private boolean userGranted;

    public void mainLoopLogin(){
        String userName;
        String userPassword;

        while(!userGranted){
            userName = enterUserName();
            checkUserName();

            userPassword = enterUserPassword();
            checkPasswordName();

            userGranted = IsValidLogin();
        }
    }

    private String enterUserName() {
        String result;
        result = Utils.userTextInput();
        return result;
    }

    private String enterUserPassword() {
        String result;
        result = Utils.userTextInput();
        return result;
    }

    private void checkUserName() {
        if (!isValidUser())
            System.out.println(View.LOGIN_ERROR_USER);
    }

    private boolean isValidUser() {
        return true;
    }

    private void checkPasswordName() {
        if (!isValidPassword())
            System.out.println(View.LOGIN_ERROR_PASSWORD);
    }

    private boolean isValidPassword() {
        return true;
    }

    private boolean IsValidLogin(){
        return true;
    }
}
