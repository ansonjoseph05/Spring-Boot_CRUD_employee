package com.sampleproject.employee.service;

import com.sampleproject.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchemployeeList();

    public Employee fetchEmployeeById(Long departmentId);

    public void deleteEmployeeById(Long employeeId);

    public Employee updateEmployee(Long employeeId, Employee department);

    public Employee fetchEmployeeByName(String employeeName);

    public List<Employee> fetchEmployeeBySalary(Long employeeSalary);
}
