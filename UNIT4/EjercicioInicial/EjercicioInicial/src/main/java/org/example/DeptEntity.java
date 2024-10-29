package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dept", schema = "public", catalog = "Employees")
public class DeptEntity {
    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employees;

    @Id
    @Column(name = "deptno")
    private Long id;

    @Column(name = "dname")
    private String nombre;

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
