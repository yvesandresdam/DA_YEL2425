package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate Mapping Activity");

        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        if (session != null) {
            System.out.println("Session successfully opened!");
        } else {
            System.out.println("Error opening session!");
        }

        Query<EmployeeEntity> myQuery =
                session.createQuery("from org.example.EmployeeEntity");
        List<EmployeeEntity> employees = myQuery.list();
        for ( EmployeeEntity employee : employees ) {
            System.out.printf("Number : %d Name: %s\n", employee.getEmpno(), employee.getEname());
        }
    }
}