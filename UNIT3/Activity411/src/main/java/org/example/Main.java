package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Activity 4.1.1");
        System.out.println("Databases with JAVA");

        // The next variables are for user information
        String url = "jdbc:postgresql://localhost:5432/VTInstitute";
        String user = "postgres";
        String password = "postgres";

        // try with resources to establish the connection
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Alternative with extraction Methods
            // ConnectionStatements(con);

            Statement statement = con.createStatement();

            // Multiple SQLQuery for debugging purposes
            // String SQLsentence = "SELECT * FROM subjects ORDER BY code";
            // String SQLsentence = "SELECT code, name FROM subjects ORDER BY code";
            String SQLsentence = "SELECT code, name, year FROM subjects ORDER BY code";

            // Set of results
            ResultSet rs = statement.executeQuery(SQLsentence);

            // The information displayed at the console
            System.out.println("===================================");
            System.out.println("Code" + "\t" + "Name" + "\t" + "Year");
            while (rs.next()) {
                System.out.println(rs.getString("code") + "\t " +
                        rs.getString("name") + "\t" +
                        rs.getString("year"));
            }

        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    private static void ConnectionStatements(Connection connection) {
        // Refactoring the code with extraction method

        try (Statement statement = connection.createStatement()) {

            // SQL Query
            String SQLsentence = "SELECT code, name, year FROM subjects ORDER BY code";

            // Result Set
            ResultSet rs = statement.executeQuery(SQLsentence);

            // The information displayed at the console
            System.out.println("===================================");
            System.out.println("Code" + "\t" + "Name" + "\t" + "Year");
            while (rs.next()) {
                System.out.println(rs.getString("code") + "\t " +
                        rs.getString("name") + "\t" +
                        rs.getString("year"));
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }
}