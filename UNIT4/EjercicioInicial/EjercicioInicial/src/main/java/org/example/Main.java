package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static SessionFactory sessionFactory = null;
    public static Session actualSession = null;

    public static void main(String[] args) {
        System.out.println("Hibernate Mapping Activity");
        System.out.println("CRUD Operations");
        System.out.println();

        // Opening a session
        actualSession = openSession();

        // Make a choice to work with DB
        // 1. Query the DB
        // 2. Create a Department
        // 3. Update an Employee
        // 4. Delete an Employee

        {
            // 1. Query
            sqlQuery();

            /* 2. Create a department
            String departmentName = "***";
            String departmentLocation = "***";
            insertDepartment(departmentName, departmentLocation);

            // 3. Update an Employee With Number
            int employeeNumber = 1234;
            updateEmployee(employeeNumber);

            // 4. Delete an Employee With Number
            int employeeNumberDelete = 4321;
            deleteEmployee(employeeNumberDelete);

            */

        }
    }

    public static Session openSession() {
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        if (session == null) {
            System.out.println();
        }
        return session;
    }

    public static void sqlQuery() {
        Query<EmployeeEntity> myQuery = actualSession.createQuery("from org.example.EmployeeEntity");
        List<EmployeeEntity> employees = myQuery.list();
        for (EmployeeEntity employee : employees) {
            System.out.printf("Number : %d Name: %s\n", employee.getEmpno(), employee.getEname());
        }
    }

    public static void insertDepartment(String userInput1, String userInput2) {
        /*  CODIGO ORIGINAL PARAMETROS POR CONSOLA
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert please the department name: ");
        String userInput1 = scanner.nextLine();
        System.out.print("Insert please the department location: ");
        String userInput2 = scanner.nextLine();
         */

        Transaction transaction = null;
        try {
            transaction = actualSession.beginTransaction();
            DeptEntity department = new DeptEntity();
            department.setDepartmentName(userInput1);
            department.setDepartmentLocation(userInput2);

            // Save/Commit of insert
            actualSession.save(department);
            transaction.commit();

        } catch (Exception e) {
            // Rollback in case of failure
            transaction.rollback();
            System.out.println(e.getMessage());
        }
    }

    public static void updateEmployee(int employeeNumberint) {
        EmployeeEntity employee = (EmployeeEntity) actualSession.get(EmployeeEntity.class, employeeNumberint);
        if (employee != null) {
            actualSession.update(employee);
        } else
            System.out.println("Employee not found");
    }

    public static void deleteEmployee(int employeeNumber) {
        EmployeeEntity employee = actualSession.get(EmployeeEntity.class, employeeNumber);
        Transaction transaction = null;
        if (employee != null) {
            transaction = actualSession.beginTransaction();
            actualSession.delete(employee);
            transaction.commit();
            System.out.println("The employee has been deleted.");
        } else {
            transaction.rollback();
            System.out.println("Employee not found.");
        }
    }
}
