package com.sampleproject.employee.service;


import com.sampleproject.employee.entity.Employee;
import com.sampleproject.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchemployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long departmentId) {
        return employeeRepository.findById(departmentId).get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);


    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee depDB = employeeRepository.findById(employeeId).get();

        if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
            depDB.setEmployeeName(employee.getEmployeeName());
        }

        if (Objects.nonNull(employee.getEmployeeAddress()) && !"".equalsIgnoreCase(employee.getEmployeeAddress())) {
            depDB.setEmployeeAddress(employee.getEmployeeAddress());
        }

        if (Objects.nonNull(employee.getEmployeeDept()) && !"".equalsIgnoreCase(employee.getEmployeeDept())) {
            depDB.setEmployeeDept(employee.getEmployeeDept());
        }

        return employeeRepository.save(depDB);

    }

    @Override
    public Employee fetchEmployeeByName(String employeeName) {
        return employeeRepository.findByEmployeeNameIgnoreCase(employeeName);
    }

    @Override
    public List<Employee> fetchEmployeeBySalary(Long employeeSalary) {
        return employeeRepository.findEmployeeLessThan(employeeSalary);
    }
}
