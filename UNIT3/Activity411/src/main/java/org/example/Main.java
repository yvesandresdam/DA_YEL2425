package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Activity 4.1.1");

        String URL = "jdbc:postgresql://localhost:5432/Test";
        String USER = "postgres";
        String PASS = "postgres";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            Statement statement = conn.createStatement();
            String SQLsentence = "SELECT code,name FROM subjects ORDER BY code";
            ResultSet rs = statement.executeQuery(SQLsentence);
            System.out.println("Code" + "\t" + "Name");
            System.out.println("-----------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getString("code") + "\t " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}