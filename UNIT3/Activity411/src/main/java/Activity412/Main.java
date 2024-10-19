package Activity412;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Activity 4.1.2");
        System.out.println("Databases with JAVA");

        // The next variables are for user information
        String url = "jdbc:postgresql://localhost:5432/VTInstitute";
        String user = "postgres";
        String password = "postgres";

        // try with resources to establish the connection
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // SQL Query to insert data into Database
            String sql = "INSERT INTO subjects (name,year,course) VALUES (?, ?, ?)";

            // Prepared Statement
            try (PreparedStatement st = con.prepareStatement(sql)) {

                // Values added to the Database
                st.setString(1,"MarkUpLanguages");
                st.setInt(2,1);
                st.setInt(3,1);

                // Executing prepared Statement
                int result = st.executeUpdate();

                // Display via console the number of new rows
                System.out.println("Filas insertadas: " + result);
            }

        } catch (SQLException e) {
            e.getErrorCode();
        }
    }
}
