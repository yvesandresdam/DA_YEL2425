public class UI {
    private final static String WELCOME_MESSAGE = "Welcome to your personal Agenda Contact JAVACONTACT";
    private final static String MAIN_PAGE_SELECTION = "Choose your option";
    private final static String ADD_CONTACT = "'A'- Add a contact to Agenda";
    private final static String LIST_CONTACT = "'L'- Display the Agenda";
    private final static String FIND_CONTACT = "'B'- Find a Contact";
    private final static String SET_NAME_CONTACT = "Set the name of the contact";
    private final static String SET_SURNAME_CONTACT = "Set the surname of the contact";
    private final static String SET_EMAIL_CONTACT = "Set the email of the contact";
    private final static String SET_PHONE_CONTACT = "Set the phone of the contact";
    private final static String SET_DESCRIPTION_CONTACT = "Set the description of the contact";

    public static void UIWelcome(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void UIMainPage(){
        System.out.println(MAIN_PAGE_SELECTION);
    }

    public static void UISelection(){
        System.out.println(ADD_CONTACT);
        System.out.println(LIST_CONTACT);
        System.out.println(FIND_CONTACT);
    }
    public static void UIAddContact(){
        System.out.println(ADD_CONTACT);
    }

    public static void UIListContact(){
        System.out.println(LIST_CONTACT);
    }

    public static void UIFindContact(){
        System.out.println(FIND_CONTACT);
    }

    public static void UISetName(){
        System.out.println(SET_NAME_CONTACT);
    }
    public static void UISetSurname(){
        System.out.println(SET_SURNAME_CONTACT);
    }
    public static void UISetEmail(){
        System.out.println(SET_EMAIL_CONTACT);
    }
    public static void UISetPhone(){
        System.out.println(SET_PHONE_CONTACT);
    }
    public static void UISetDescription(){
        System.out.println(SET_DESCRIPTION_CONTACT);
    }
}
