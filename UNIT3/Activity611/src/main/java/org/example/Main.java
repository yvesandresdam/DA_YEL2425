package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Activity 6.1.1");

        String URL = "jdbc:postgresql://localhost:5432/Test";
        String USER = "postgres";
        String PASS = "postgres";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement pstmt = conn.prepareStatement("Insert into subjects (name,year) values( ?, ? )");
            pstmt.setString( 1, "History of Maths." );
            pstmt.setInt( 2, 1 );
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}