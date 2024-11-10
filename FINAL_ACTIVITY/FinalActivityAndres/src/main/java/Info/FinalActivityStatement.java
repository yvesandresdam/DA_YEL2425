package Info;

public class FinalActivityStatement {

    // DEV: This class contains all information regarding to the Final Activity Statements.
    // This is useful information to complete the activity.

}

/*
    INFORMATION
    -----------
    Final Activity
    First Period
    Online Market Sellers


    FIRST_REVIEW: Monday, 11th November 2024
    ----------------------------------------
    Objectives:
    · Basic Structure of the application
    · Connection to the Posgres Database
    · User Interface with JAVAFX


    1. E-R SCHEMA
    "Using the provided script (online-market-2425.sql), the student must generate the
    database that will fit the given e-r schema".

    "We have to develop an application that should permit a seller
    registered in our online market to sell a product from the list of previously available
    products".

    The next related tables are needed for the first review of the application.

    + SELLER
    --------
    int:            sellerID
    varchar(100):   name
    varchar(100):   password

    + PRODUCTS
    ----------
    int:            productID
    varchar(100):   productName
    varchar(1000):  description


    + SELLER_PRODUCTS
    -----------------
    int:            sellerProductID
    int:            sellerID
    int:            productID
    numeric(10,2):  price


    2. USER LOGIN
    "The first thing to do will be to log the seller into the app. The ‘Sellers’ table
    have two ‘password’ fields, the ‘plain_password' field and the ‘password’ field (is the MD5 of the
    previous field)".
    Our application should ask for a combination of user and password and check if the pair
    is present in the database. If it is, then the main view will be presented to the seller. If
    not, it will be informed that an error has occurred".


    3. USER MAIN PAGE
    "The user would like to set the application preferences and personal data.
    Keep in mind that, if the field has a formatted value, it should be checked. Also, every
    mandatory field must be introduced. The CIF field shouldn’t be modified. When any field
    does not comply with the requirements, the user must be informed. Finally, you should
    ensure that the password field has been correctly typed".
*/
