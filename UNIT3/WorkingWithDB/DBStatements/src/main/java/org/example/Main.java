package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Working with DB");

        String dbName = "TestFirst";
        //connectingDB(dbName);

        String tableName = "School";
        //createTable(tableName);

        String fieldName1 = "numberStudents";
        //createFieldInt(fieldName1);
        String fieldName2 = "numberPromotion";
        //createFieldInt(fieldName2);
        String fieldName3 = "numberRepeats";
        //createFieldInt(fieldName3);

        String schoolName = "VTHighLands";
        int numberStudents = 1000;
        //insertIntoTable(schoolName, numberStudents);
        //insertIntoTable(numberStudents);

    }

    public static boolean connectingDB(String dbName) {
        String URL = "jdbc:postgresql://localhost:5432/" + dbName;
        String USER = "postgres";
        String PASS = "postgres";
        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {
            if (c != null) {
                System.out.println("You've connected to the DB!");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean createTable(String name) {
        String dbName = "TestFirst";
        String URL = "jdbc:postgresql://localhost:5432/" + dbName;
        String USER = "postgres";
        String PASS = "postgres";

        String sql = "CREATE TABLE " + name + " ("
                + "id SERIAL PRIMARY KEY, "
                + "nombreEscuela VARCHAR(100) "
                + ")";

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {

            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.executeUpdate();
                System.out.println("Tabla '" + name + "' creada exitosamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean createFieldInt(String columnName) {
        String dbName = "TestFirst";
        String URL = "jdbc:postgresql://localhost:5432/" + dbName;
        String USER = "postgres";
        String PASS = "postgres";

        String sql = String.format("ALTER TABLE school ADD COLUMN %s INT", columnName);

        try (Connection c = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = c.prepareStatement(sql)) {
            {
                pstmt.executeUpdate();
                System.out.println("Campo '" + columnName + "' creadx exitosamente.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean insertIntoTable(String nameSchool, int numberStudents) {
        String dbName = "TestFirst";
        String URL = "jdbc:postgresql://localhost:5432/" + dbName;
        String USER = "postgres";
        String PASS = "postgres";

        String sql = String.format("INSERT INTO school (nombreescuela,numberstudents) VALUES ('%s', %d)", nameSchool, numberStudents);

        try (Connection c = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = c.prepareStatement(sql)) {
            {
                pstmt.executeUpdate();
                System.out.println("Valor '" + nameSchool + "' añadido exitosamente.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}