public class Main {
    public static void main(String[] args) {
        System.out.println("Activities Unit 3");
    }
}

/*
    DOCUMENTATION
    -------------

    2.1. ACTIVITIES
    ---------------

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
    ---------------

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


    6.1. ACTIVITIES
    ---------------

    1. Rewrite activity 4.1.2 to use a PreparedStatement. Instead of introducing
    one subject at a time, allow the user to introduce as many subjects as
    desired, using a loop, ending with a breaking signal (a null subject code,
    or any other valid signal).
    2. Using a PreparedStatement, create a new table called ‘courses’, with two
    columns, code (a serial) and name (a varchar of length 90). Introduce a pair
    of valid values, like ‘Multiplatform app development’ and ‘Web
    development’.
    3. Add also a new column to ‘subjects’ called ‘course’. It will be a foreign key
    referencing the column ‘code’ in the table ‘courses’. To know how to write
    a foreign key in PostgreSQL, check this link. Keep in mind that, before
    creating the foreign key constraint, you will have to update the column
    ‘subjects.course’ to have valid values (the code of one of the courses in
    table ‘course’).

    7.4. ACTIVITIES
    ---------------

    1. Using the ‘employees’ database, create a new stored procedure to list all
    the employees on a specific job.
    2. Create another procedure to return employees belonging to a specific
    department.
    3. Create a procedure to list all the employees which name matches a pattern
    using wildcards, for example, the pattern “a%” will return “ALLEN”,
    “ADAMS”.
    4. Create a JAVA application that permits to call any of the previous
    procedures.
    
 */
