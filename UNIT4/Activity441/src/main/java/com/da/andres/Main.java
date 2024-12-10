package com.da.andres;

public class Main {
    public static void main(String[] args) {
        System.out.println("hibernate JAVA PROJECT");
        System.out.println();
    }
}


/*
    DOCUMENTATION
    -------------

    Al margen del contenido que tenemos en los apuntes de la asignatura,
    voy a documentar los pasos para hacer funcional un proyecto de mapeo relacional hibernate.

    1. He creado un proyecto nuevo, de tipo 'Maven'. He añadido mi propia marca de 'GroupID'
    2. En el fichero 'pom.xml', hay que añadir las lineas correspondientes a 'hibernate'.
       Se pueden encontrar en el repositorio oficial de Maven.
    3. Tambien he añadido las lineas que hacen funcionar la conexion a PostgreSQL
    4. A continuación y solo como comprobacion de que el proyecto funciona hasta la fecha,
       activo la funcionalidad de IntellijIDEA que me permite comunicarme con una base de datos,
       introduzco los datos de mi base de datos POSTGRES y ejecuto una sencilla query 'SELECT * from employee.
       Afortunadamente, me muestra por pantalla una coleccion de empleados con sus trabajos y sus departamentos.
       Tambien ejecuto el punto de acceso Main y por el momento, no recibo ningun error de compilación.
    5. Procedo a cargar 'Hibernate'
 */