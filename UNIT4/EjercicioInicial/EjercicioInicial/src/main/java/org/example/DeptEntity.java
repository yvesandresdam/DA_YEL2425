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
    private String departmentName;

    @Column(name = "loc")
    private String departmentLocation;

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public String getDepartmentName(){
        return departmentName;
    }
    public void setDepartmentName(String value){
        departmentName = value;
    }
    public Long getId() {
        return id;
    }
    public void setId(long ID){
        id = ID;
    }
    public String getDepartmentLocation() {
        return departmentLocation;
    }
    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }
}
