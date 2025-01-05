package controller;

import model.Category;
import model.Product;
import org.hibernate.Session;
import view.ModelType;
import view.UI;
import view.VMCategory;
import view.VMProduct;

import java.util.List;
import java.util.Scanner;

public class Controller {

    // This class manages both the model and the view of the Application.
    // Queries the Database with functions related to named query stored at the QueryDB Class,
    // and displays the resulting data with functions from the view Package.

    // Variables for working with controller
    private Session session;
    private Scanner scanner;
    private Integer userSelection;
    private Integer userSelectionQueryCategory;
    private Integer userSelectionQueryProduct;
    private Boolean mainConditionLoop;
    private Boolean queryCategoryLoop;
    private Boolean queryProductLoop;

    public Controller(Session session) {
        this.session = session;
    }

    public void launchMainController() {
        // creating local variables
        scanner = new Scanner(System.in);
        mainConditionLoop = true;
        queryCategoryLoop = true;
        queryProductLoop = true;

        // launching main loop of the query application
        mainLoop();
    }

    // PRIVATE functions
    private void mainLoop() {
        // Welcome message
        UI.welcomeMessage();

        // Main Loop
        while (mainConditionLoop) {
            // Displaying the user selection
            UI.querySelection();
            UI.queryOption();

            // Getting the user selection
            userSelection = scanner.nextInt();
            UI.printingBlankLine();

            // Selecting query from 'CATEGORY' 'PRODUCT' or 'USER'
            if (userSelection == 1)
                queryCategory();
            else if (userSelection == 2)
                queryProduct();
            else if (userSelection == 3)
                UI.functionNotYetImplemented();
            else if (userSelection == 0)
                mainConditionLoop = false;
            else
                UI.error();
        }

        // Quitting Query and exiting the application
        UI.exitApplication();
    }

    // Querying the 'CATEGORY' table
    private void queryCategory() {
        // Asking the user about the 'CATEGORY' Query
        while (queryCategoryLoop) {
            UI.queryingCategory();
            userSelectionQueryCategory = scanner.nextInt();
            UI.printingBlankLine();

            // Every 'choice' is a DIFFERENT QUERY OF THE CATEGORY TABLE
            // Every 'Query' has a VIEW MODELTYPE OF VISUALIZATING DATA

            // Selection 1 queries ALL DATABASE CATEGORY TABLE
            if (userSelectionQueryCategory == 1) {
                // Getting query result in LIST Collection
                QueryCategory queryALL = new QueryCategory(session);
                List<Category> resultALL = queryALL.selectAllCategories();

                // The data List is parameter of the view model function
                viewResultQueryCategory(resultALL);
            }

            // Selection 2 queries DATABASE CATEGORY TABLE by id
            else if (userSelectionQueryCategory == 2) {
                // Asking the user for the 'id' of the category
                UI.userInputQueryCategory();
                Integer id = scanner.nextInt();

                // Getting query result in LIST Collection
                QueryCategory queryWithId = new QueryCategory(session);
                List<Category> resultWithID = queryWithId.selectCategoryWithID(id);

                // The data List is parameter of the view model function
                viewResultQueryCategory(resultWithID);
            }

            // Selection 3 queries DATABASE CATEGORY TABLE by name
            else if (userSelectionQueryCategory == 3) {
                // Asking the user for the 'name' of the category
                UI.userInputQueryCategoryName();
                String name = scanner.nextLine();

                // Getting query result in LIST Collection
                QueryCategory queryWithName = new QueryCategory(session);
                List<Category> resultWithName = queryWithName.selectCategoryWithName(name);

                // The data List is parameter of the view model function
                viewResultQueryCategory(resultWithName);
            }

            // Selection 4 exits the query main Loop
            else if (userSelectionQueryCategory == 0) {
                queryCategoryLoop = false;
            } else {
                UI.error();
            }
        }
    }

    // Querying the 'PRODUCT' table
    private void queryProduct() {
        // Asking the user about the 'CATEGORY' Query
        while (queryProductLoop) {
            UI.queryingProduct();
            userSelectionQueryProduct = scanner.nextInt();
            UI.printingBlankLine();

            // Every 'choice' is a DIFFERENT QUERY OF THE PRODUCT TABLE
            // Every 'Query' has a VIEW MODELTYPE OF VISUALIZATING DATA

            // Selection 1 queries ALL DATABASE CATEGORY TABLE
            if (userSelectionQueryProduct == 1) {
                // Getting query result in LIST Collection
                QueryProduct queryALL = new QueryProduct(session);
                List<Product> resultALL = queryALL.selectAllProducts();

                // The data List is parameter of the view model function
                viewResultQueryProduct(resultALL);
            }

            // Selection 2 queries DATABASE CATEGORY TABLE by id
            else if (userSelectionQueryProduct == 2) {
                // Asking the user for the 'id' of the category
                UI.userInputQueryProduct();
                Integer id = scanner.nextInt();

                // Getting query result in LIST Collection
                QueryProduct queryWithId = new QueryProduct(session);
                List<Product> resultWithID = queryWithId.selectProductWithID(id);

                // The data List is parameter of the view model function
                viewResultQueryProduct(resultWithID);
            }

            // Selection 3 queries DATABASE CATEGORY TABLE by name
            else if (userSelectionQueryProduct == 3) {
                // Asking the user for the 'name' of the category
                UI.userInputQueryCategoryName();
                String name = scanner.nextLine();

                // Getting query result in LIST Collection
                QueryProduct queryWithName = new QueryProduct(session);
                List<Product> resultWithName = queryWithName.selectProductWithName(name);

                // The data List is parameter of the view model function
                viewResultQueryProduct(resultWithName);
            }

            // Selection 4 exits the query main Loop
            else if (userSelectionQueryProduct == 0) {
                queryProductLoop = false;
            } else {
                UI.error();
            }
        }
    }

    private void viewResultQueryCategory(List<Category> listResult) {
        // Asks the user for the model of visualization of data
        // This model of visualization is DIFFERENT SCHEMAS OF VISUALIZATION THE QUERIED DATA
        UI.displayingCategoryData();

        ModelType modelDataView;
        Integer userChoice = scanner.nextInt();

        if (userChoice == 1)
            modelDataView = ModelType.MODEL1;
        else if (userChoice == 2)
            modelDataView = ModelType.MODEL2;
        else if (userChoice == 3)
            modelDataView = ModelType.MODEL3;
        else if (userChoice == 4)
            modelDataView = ModelType.MODEL4;
        else {
            UI.error();
            modelDataView = ModelType.MODEL1;
        }

        // Displaying the data with Visualizating Model Class
        VMCategory viewCategory = new VMCategory();
        viewCategory.listAllCategory(listResult, modelDataView);
    }

    private void viewResultQueryProduct(List<Product> listResult) {
        // Asks the user for the model of visualization of data
        // This model of visualization is DIFFERENT SCHEMAS OF VISUALIZATION THE QUERIED DATA
        UI.displayingProductData();

        ModelType modelDataView;
        Integer userChoice = scanner.nextInt();

        if (userChoice == 1)
            modelDataView = ModelType.MODEL1;
        else if (userChoice == 2)
            modelDataView = ModelType.MODEL2;
        else if (userChoice == 3)
            modelDataView = ModelType.MODEL3;
        else if (userChoice == 4)
            modelDataView = ModelType.MODEL4;
        else {
            UI.error();
            modelDataView = ModelType.MODEL1;
        }

        // Displaying the data with Visualizating Model Class
        VMProduct viewProduct = new VMProduct();
        viewProduct.listAllProduct(listResult, modelDataView);
    }
}
