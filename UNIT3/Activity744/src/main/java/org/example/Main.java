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
        // procedure n1 = findByJob
        int numberPocedure = 1;
        DBProceduresCalling.callingProcedures(numberPocedure);
    }
}