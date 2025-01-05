package view;

public class UI {
    private static final String WELCOME_MESSAGE_FIRST = "EZShopFINDER";
    private static final String WELCOME_MESSAGE_SECOND = "Welcome to your personal online shop-database query application";
    private static final String QUESTION_QUERY_FIRST = "Which section do you want to query?";
    private static final String OPTION_QUERY_FIRST = "[1]_Query 'CATEGORY'";
    private static final String OPTION_QUERY_SECOND = "[2]_Query 'PRODUCT'";
    private static final String OPTION_QUERY_THIRD = "[3]_Query 'USER'";
    private static final String OPTION_QUERY_FINAL = "[0]_EXIT Query Application";

    private static final String OPTION_QUERY_CATEGORY_FIRST = "You are querying the 'CATEGORY' Database";
    private static final String OPTION_QUERY_CATEGORY_SECOND = "Which query do you want to make?";
    private static final String OPTION_QUERY_CATEGORY_THIRD = "[1]Query ALL 'CATEGORY' Database";
    private static final String OPTION_QUERY_CATEGORY_FOUR = "[2]Query 'CATEGORY' By 'ID'";
    private static final String OPTION_QUERY_CATEGORY_FIVE = "[3]Query 'CATEGORY' By 'NAME'";
    private static final String OPTION_QUERY_CATEGORY_SIX = "[0]Back to Main Menu";

    private static final String OPTION_QUERY_PRODUCT_FIRST = "You are querying the 'PRODUCT' Database";
    private static final String OPTION_QUERY_PRODUCT_SECOND = "Which query do you want to make?";
    private static final String OPTION_QUERY_PRODUCT_THIRD = "[1]Query ALL 'PRODUCT' Database";
    private static final String OPTION_QUERY_PRODUCT_FOUR = "[2]Query 'PRODUCT' By 'ID'";
    private static final String OPTION_QUERY_PRODUCT_FIVE = "[3]Query 'PRODUCT' By 'NAME'";
    private static final String OPTION_QUERY_PRODUCT_SIX = "[0]Back to Main Menu";


    private static final String QUERYING_CATEGORY_WITH_ID = "Please insert the id number of the category...";
    private static final String QUERYING_CATEGORY_WITH_NAME = "Please insert the name of the category...";

    private static final String QUERYING_PRODUCT_WITH_ID = "Please insert the id number of the product...";
    private static final String QUERYING_PRODUCT_WITH_NAME = "Please insert the name of the product...";

    private static final String QUESTION_MODEL_TYPE = "Please choose a model of visualizating data";
    private static final String MODEL_TYPE_FIRST = "[1]'Category' - 'Name'";
    private static final String MODEL_TYPE_FIRST_2 = "[1]'Category' - 'Name' - 'Description'";
    private static final String MODEL_TYPE_SECOND = "[2]'Category'";
    private static final String MODEL_TYPE_THIRD = "[3]'Name'";


    private static final String OPTION_QUERY_NOT_YET_IMPLEMENTED = "Function currently not available";
    private static final String EXIT_APPLICATION = "Quitting the application, please wait...";
    private static final String ERROR = "Please, insert a valid option...";
    private static final String BLANK_LINE = "";

    public static void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE_FIRST);
        System.out.println(WELCOME_MESSAGE_SECOND);
    }

    public static void querySelection() {
        System.out.println(QUESTION_QUERY_FIRST);
    }

    public static void queryOption() {
        System.out.println(OPTION_QUERY_FIRST);
        System.out.println(OPTION_QUERY_SECOND);
        System.out.println(OPTION_QUERY_THIRD);
        System.out.println(OPTION_QUERY_FINAL);
    }

    public static void error() {
        System.out.println(ERROR);
    }

    public static void exitApplication() {
        System.out.println(EXIT_APPLICATION);
    }

    public static void queryingCategory() {
        System.out.println(OPTION_QUERY_CATEGORY_FIRST);
        System.out.println(OPTION_QUERY_CATEGORY_SECOND);
        System.out.println(OPTION_QUERY_CATEGORY_THIRD);
        System.out.println(OPTION_QUERY_CATEGORY_FOUR);
        System.out.println(OPTION_QUERY_CATEGORY_FIVE);
        System.out.println(OPTION_QUERY_CATEGORY_SIX);
    }

    public static void displayingCategoryData() {
        System.out.println(QUESTION_MODEL_TYPE);
        System.out.println(MODEL_TYPE_FIRST);
        System.out.println(MODEL_TYPE_SECOND);
        System.out.println(MODEL_TYPE_THIRD);
    }

    public static void queryingProduct() {
        System.out.println(OPTION_QUERY_PRODUCT_FIRST);
        System.out.println(OPTION_QUERY_PRODUCT_SECOND);
        System.out.println(OPTION_QUERY_PRODUCT_THIRD);
        System.out.println(OPTION_QUERY_PRODUCT_FOUR);
        System.out.println(OPTION_QUERY_PRODUCT_FIVE);
        System.out.println(OPTION_QUERY_PRODUCT_SIX);
    }

    public static void displayingProductData() {
        System.out.println(QUESTION_MODEL_TYPE);
        System.out.println(MODEL_TYPE_FIRST_2);
        System.out.println(MODEL_TYPE_SECOND);
        System.out.println(MODEL_TYPE_THIRD);
    }

    public static void printingBlankLine(){
        System.out.println(BLANK_LINE);
    }

    public static void functionNotYetImplemented(){
        System.out.println(OPTION_QUERY_NOT_YET_IMPLEMENTED);
    }

    public static void userInputQueryCategory(){
        System.out.println(QUERYING_CATEGORY_WITH_ID);
    }

    public static void userInputQueryCategoryName(){
        System.out.println(QUERYING_CATEGORY_WITH_NAME);
    }

    public static void userInputQueryProduct(){
        System.out.println(QUERYING_PRODUCT_WITH_ID);
    }

    public static void userInputQueryProductName(){
        System.out.println(QUERYING_PRODUCT_WITH_NAME);
    }
}
