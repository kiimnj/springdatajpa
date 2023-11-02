package com.example.springdatajpa.controller;

import com.example.springdatajpa.domain.Employee;
import com.example.springdatajpa.domain.EmployeeUpdateDto;
import com.example.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable String empId) {
        return employeeService.getEmployee(empId).get();
    }

    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable String empId,
                                 @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        return employeeService.updateEmployee(employeeUpdateDto);
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        return employeeService.deleteEmployee(empId);
    }

}
