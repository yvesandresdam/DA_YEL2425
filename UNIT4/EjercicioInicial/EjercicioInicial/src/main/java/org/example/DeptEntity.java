package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "dept", schema = "public", catalog = "Employees")
public class DeptEntity {
    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employees;

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
