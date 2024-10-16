public class Main {
    public static void main(String[] args) {
        System.out.println("Activities Unit 3");
    }
}

/*
    DOCUMENTATION
    -------------

    2.1. ACTIVITIES
    1. Using the PgAdmin4 utility, create a new database called VTInstitute
    (Vocational Training Institute). Within this database, create a new table called
    ‘subjects’ with three fields:
        • Code: a sequence field (find out what a sequence field is in
        PostgreSQL).
        • Name: the name of the course, a string with a maximum length of
        50 chars.
        • Year: an integer showing in which year is due to be taken the course.

    2. Using the Pgadmin Query tool and the SQL INSERT clause, add the following
    data to the ‘subjects’ table:
        • ‘DATA ACCESS’, second year
        • ‘DEVELOPMENT ENVIRONMENTS’, first year
        • ‘DATABASE MANAGEMENT SYSTEMS’, first year
        • ‘SERVICES AND PROCESSES’, second year
    3. Create a new database called ‘employees’. Download and run the script
    ‘employee-dept.sql’. Check that the script has finished successfully
    creating two tables with records.

    4.1. ACTIVITIES
    1. Create a Maven project with IntelliJ IDEA to run the previous application.
    Verify that you obtain the desired result. You will have to add the
    PostgreSQL dependency to the POM.XML file in order to properly run the
    application. Modify the application to show also the year in which every
    course is taken. Finally, add an error control block (try … catch …).

    2. Using the method executeUpdate, modify the previous application to
    insert a new subject into the ‘subjects’ table (for example, ‘Markup
    Languages’, first year). You should print out on the screen the value
    returned by the method.

    3. Using either execute or executeUpdate, alter the table ‘subjects’ to
    add a new field, ‘Hours’, an integer showing the yearly hours of the subject.

    
 */
