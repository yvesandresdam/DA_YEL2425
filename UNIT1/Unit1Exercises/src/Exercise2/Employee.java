package Exercise2;

public class Employee extends Person {
    private double salary;
    private Company company;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double value) throws IllegalArgumentException {
        if (value < 0)
            throw new IllegalArgumentException("El salario introducido es incorrecto");
        this.salary = value;
    }

    public Company getCompany() throws IllegalArgumentException {
        if (company == null)
            throw new IllegalArgumentException("No existe compañia valida");
        return company;
    }

    public void setCompany(Company company) throws IllegalArgumentException {
        if (company == null)
            throw new IllegalArgumentException("La compañia introducida es incorrecta");
        this.company = company;
    }
}
