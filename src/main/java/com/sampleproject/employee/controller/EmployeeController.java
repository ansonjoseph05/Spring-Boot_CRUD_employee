package com.sampleproject.employee.controller;

import com.sampleproject.employee.entity.Employee;
import com.sampleproject.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);

    }

    @GetMapping("/employee")
    public List<Employee> fetchDepartmentList() {
        return employeeService.fetchemployeeList();
    }

    @GetMapping("/employee/{id}")
    public Employee fetchDepartmentById(@PathVariable("id") Long departmentId) {
        EmployeeController departmentService;
        return employeeService.fetchEmployeeById(departmentId);

    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted Successfully !!";

    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee department) {
        return employeeService.updateEmployee(employeeId, department);
    }

    @GetMapping("/employee/name/{name}")
    public Employee fetchEmployeeByName(@PathVariable("name") String employeeName) {
        return employeeService.fetchEmployeeByName(employeeName);
    }

    @GetMapping("/employee/salary/{s}")
    public List<Employee> fetchEmployeeBySalary(@PathVariable("s") Long employeeSalary) {
        return employeeService.fetchEmployeeBySalary(employeeSalary);


    }

}