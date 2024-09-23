package Exercise1;

public class Student {
    private String name;
    private int mark;

    // La funcion devuelve el nombre del estudiante
    public String getName() {
        return name;
    }

    // La funcion comprueba que se introduce un nombre valido
    public void setName(String name) {
        if (name == null)
            return;
        this.name = name;
    }

    // La funcion devuelve la nota del studiante
    public int getMark() {
        return mark;
    }

    // La funcion comprueba que la nota introducida es valida
    public void setMark(int mark) {
        if (mark < 0 || mark > 10)
        {
            System.out.println("La nota introducida no es valida");
            return;
        }
        this.mark = mark;
    }

    // Funcion que lanza una excepcion cuando la nota no es valida
    public void setMarkAlternative(int mark) throws IllegalArgumentException{
        if ( mark < 0 || mark > 10)
            throw new IllegalArgumentException("El numero introducido no es valido");
        this.mark = mark;
    }

    // La funcion comprueba que la nota es superior a 5
    public Boolean isOver5() {
        return mark >= 5;
    }
}
