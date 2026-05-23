package org.example.employeebook.service;

import org.example.employeebook.Employee;
import org.example.employeebook.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceDepartment {

    private final EmployeeService employeeService;

    public EmployeeServiceDepartment(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalaryDepartment(int numberDepartment) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getNumberDepartment() == numberDepartment)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee minSalaryDepartment(int numberDepartment) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getNumberDepartment() == numberDepartment)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> getAllEmployeeDepartment(int numberDepartment) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getNumberDepartment() == numberDepartment)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeeGroupByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(groupingBy(Employee::getNumberDepartment));
    }
}
