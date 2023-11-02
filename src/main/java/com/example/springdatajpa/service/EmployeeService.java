package com.example.springdatajpa.service;

import com.example.springdatajpa.domain.Employee;
import com.example.springdatajpa.domain.EmployeeUpdateDto;
import com.example.springdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true) //안붙여도 됨
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //C
//    @Transactional //서비스에서 해줘야 함
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee); //ctrl+alt+v로 리턴타입 확인
    }
    //R
    @Transactional(readOnly = true) //클래스에서 달아둔건 false
    public Optional<Employee> getEmployee(String empId) {
        return employeeRepository.findById(empId); //Optional : nullPointExcpt 발생 방지
    }

    //U
//    @Transactional
    public String updateEmployee(EmployeeUpdateDto employeeUpdateDto) {
        Optional<Employee> findEmployee = employeeRepository.findById(employeeUpdateDto.getEmpId());
        Employee employee = findEmployee.get();
        employee.setDeptId(employeeUpdateDto.getDeptId());
        employee.setSalary(employeeUpdateDto.getSalary());
        employeeRepository.save(employee);
        return "수정완료";
    }
    //D
    public String deleteEmployee(String empId) {
        employeeRepository.deleteById(empId);
        return "삭제완료";
    }
}
