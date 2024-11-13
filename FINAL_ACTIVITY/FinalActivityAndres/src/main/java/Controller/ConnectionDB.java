package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {

    // DEV: Connection to PostgreSQL Database
    // Manages the connection with the Database
    // ----------------------------------------

    private static String url;
    private static String user;
    private static String password;

    public void setConnection(String databaseName, String userName, String userPassword) {
        url = "jdbc:postgresql://localhost:5432/" + databaseName;
        user = userName;
        password = userPassword;
    }

    public void startConnection() {
        System.out.println("Connecting to PostgreSQL database...");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database");

            // TEST
            testingDatabase("sellers");
        } catch (Exception e) {
            System.out.println("Error connecting the Database");
        }
    }

    public void testingDatabase(String tableName){
        System.out.println("Testing the Database");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database");

            Statement statement = conn.createStatement();
            String SQLsentence = String.format("SELECT * FROM %s", tableName);
            ResultSet rs = statement.executeQuery(SQLsentence);

            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error connecting database");
        }
    }
}
