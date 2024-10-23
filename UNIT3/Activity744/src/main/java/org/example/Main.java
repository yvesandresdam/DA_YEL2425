package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Activity 7.4.4");
        System.out.println("Calling Procedures");
        System.out.println();

        DBPC DBProceduresCalling = new DBPC();

        // Checking the DB Connection
        // DBProceduresCalling.connectDB();

        // Checking the Procedures list
        // procedure n1 = findByJob          ||      ProcedureType.FIND_BY_JOB
        // procedure n2 = findByDepartment   ||      ProcedureType.FIND_BY_DEPARTMENT
        // procedure n3 = findByName         ||      ProcedureType.FIND_BY_NAME
        // procedure n4 = findByNameWildcard ||      ProcedureType.FIND_BY_NAME_WILDCARD

        int numberPocedure = 2;
        String wildcard = "A%";
        DBProceduresCalling.callingProcedures(numberPocedure, wildcard);
    }
}