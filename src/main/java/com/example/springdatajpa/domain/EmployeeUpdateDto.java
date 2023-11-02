package com.example.springdatajpa.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity db와 매핑되는게 아닌 레이어끼리만 주고받기 떄문에 사용 X
public class EmployeeUpdateDto {
    @Id
    @Column(name="emp_id")
    private String empId;
    @Column(name="dept_id")
    private int deptId;
    private Long salary;

    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public String getEmpId() {
        return empId;
    }
    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public Long getSalary() {
        return salary;
    }
    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
