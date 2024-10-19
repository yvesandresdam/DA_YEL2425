package Activity413;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Activity 4.1.3");
        System.out.println("Databases with JAVA");

        // The next variables are for user information
        String url = "jdbc:postgresql://localhost:5432/VTInstitute";
        String user = "postgres";
        String password = "postgres";

        // try with resources to establish the connection
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // SQL Query to add a new column
            String sql = "ALTER TABLE subjects ADD COLUMN hour TIME";

            // Prepared Statement
            try (PreparedStatement stmt = con.prepareStatement(sql)) {

                // Ejecutar la sentencia
                int result = stmt.executeUpdate();

                // Mostrar el resultado
                System.out.println("New row hour added");
            }
        } catch (
                SQLException e) {
            e.getErrorCode();
        }
    }
}
