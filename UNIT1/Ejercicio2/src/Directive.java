import java.util.Set;
import java.util.HashSet;

public class Directive {
    private String category;
    private Set<Employee> subordinados = new HashSet<Employee>();

    public Employee getSubordinatesWithName(String name) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("El nombre introducido es incorrecto");
        for (Employee employee : subordinados) {
            String employeeSearch = employee.getName();
            if (employeeSearch.equals(name))
                return employee;
        }
        return null;
    }

    public int getSubordinatesCount(){
        return subordinados.size();
    }

    public void addSubordinate (Employee employee) throws IllegalArgumentException{
        if (employee == null)
            throw new IllegalArgumentException("El empleado introducido es incorrecto");
        subordinados.add(employee);
    }

}
