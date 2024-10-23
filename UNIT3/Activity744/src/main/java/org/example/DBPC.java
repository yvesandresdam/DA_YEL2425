package org.example;

import java.sql.*;

public class DBPC {
    private final static String databaseName = "Employees";
    private final static String userName = "postgres";
    private final static String userPass = "postgres";
    private final static String findByJob = "employees_find_by_job";
    private final static String findByDepartment = "employees_find_by_department";
    private final static String findByName = "employees_find_by_name";
    private final static String findByNameWildcard = "employees_find_by_name_bis";

    public void connectDB(){
        String URL = "jdbc:postgresql://localhost:5432/" + databaseName;
        try (Connection connection = DriverManager.getConnection(URL, userName, userPass)) {
            if(connection != null)
                System.out.println("Connection succeed!");
            else
                System.out.println("Connection failed!");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void callingProcedures(int numberProcedure, String wildcard) {

        // Connecting the Database
        String URL = "jdbc:postgresql://localhost:5432/" + databaseName;
        try (Connection connection = DriverManager.getConnection(URL, userName, userPass)) {

            // User Procedure Selection
            String procedureName = "";
            if(numberProcedure == 1){
                procedureName = String.format("{call %s('SALESMAN')}",findByJob);
            }
            else if(numberProcedure == 2){
                procedureName = String.format("{call %s('20')}",findByDepartment);
            }
            else if(numberProcedure == 3){
                procedureName = String.format("{call %s('A%%')}",findByName, "A%"); // Como curiosidad, el caracter % escapa con '%%'
                //String procedureNameTest1 = String.format("{call %s('%s')}",findByName, "A%");  // Refactorizando
                //String procedureNameTest2 = String.format("{call %s('%s')}",findByName, finder);  // Refactorizando
            }
            else if(numberProcedure == 4){
                procedureName = String.format("{call %s('%s')}",findByNameWildcard, wildcard);  // Refactorizando
            }
            else{
                System.out.println("Procedure number not valid");
            }

            // Calling procedure with JAVA
            CallableStatement statement = connection.prepareCall(procedureName);
            ResultSet resultSet = statement.executeQuery();

            // Displaying Data
            System.out.println("Code" + "\t" + "Name" + "\t" + "Job " + "\t\t" + "DPT");
            System.out.println("--------------------------------------------------");
            while (resultSet.next()) {
                String column1 = resultSet.getString((1));
                String column2 = resultSet.getString((2));
                String column3 = resultSet.getString((3));
                String column4 = resultSet.getString((4));
                System.out.println(column1 + "\t" + column2 + "\t" + column3 + "\t\t" + column4);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
