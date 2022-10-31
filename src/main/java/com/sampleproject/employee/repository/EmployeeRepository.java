package com.sampleproject.employee.repository;

import com.sampleproject.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query
    (value="select * from employee s where s.employeeSalary<?1",
            nativeQuery=true)

    public List<Employee> findEmployeeLessThan(Long employeeSalary);


    public Employee findByEmployeeNameIgnoreCase(String employeeName);





}
