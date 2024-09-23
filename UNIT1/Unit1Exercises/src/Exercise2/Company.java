package Exercise2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Company {
    private String name;

    private List<Customer> customersList = new ArrayList<Customer>();
    private int totalCustomers;

    private Set<Employee> employeesList = new HashSet<Employee>();
    private int totalEmployees;

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("El nombre introducido es incorrecto");
        this.name = name;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void addClient(Customer customer) throws IllegalArgumentException {
        if (customer == null)
            throw new IllegalArgumentException("El cliente introducido es incorrecto");
        customersList.add(customer);
        totalCustomers = customersList.size();
    }

    public Employee getEmployeeWithName(String name) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("El nombre introducido es invalido");

        for (Employee employee : employeesList) {

            String searchName = employee.getName();
            if (searchName.equals(name))
                return employee;
        }
        return null;
    }

    public int getTotalEmployees(){
        return totalEmployees;
    }

    private void setTotalEmployees(){
        totalEmployees = employeesList.size();
    }

    private void setClientsNumber() {
        totalCustomers = customersList.size();
    }
}
