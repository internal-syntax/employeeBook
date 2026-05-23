package org.example.employeebook.controller;

import org.example.employeebook.Employee;
import org.example.employeebook.service.EmployeeServiceDepartment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class EmployeeControllerDepartments {

    private final EmployeeServiceDepartment employeeServiceDepartment;

    public EmployeeControllerDepartments(EmployeeServiceDepartment employeeServiceDepartment) {
        this.employeeServiceDepartment = employeeServiceDepartment;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryDepartmentsEmployee(@RequestParam int numberDepartment) {
        return employeeServiceDepartment.maxSalaryDepartment(numberDepartment);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryDepartmentsEmployee(@RequestParam int numberDepartment) {
        return employeeServiceDepartment.minSalaryDepartment(numberDepartment);
    }

    @GetMapping("/all")
    public Collection<Employee> getAllEmployeeByDepartment(@RequestParam int numberDepartment) {
        return employeeServiceDepartment.getAllEmployeeDepartment(numberDepartment);
    }

    @GetMapping("/all/group")
    public Map<Integer, List<Employee>> getAllEmployeeGroupByDepartment() {
        return employeeServiceDepartment.getAllEmployeeGroupByDepartment();
    }
}
