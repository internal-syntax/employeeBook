package org.example.employeebook.service;

import org.example.employeebook.Employee;
import org.example.employeebook.exceptions.EmployeeAlreadyAddedException;
import org.example.employeebook.exceptions.EmployeeNotFoundException;
import org.example.employeebook.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int MAXIMUM_NUMBER_OF_EMPLOYEES = 5;

    protected final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, int numberDepartment, int salary) {
        Employee employee = new Employee(firstName, lastName, numberDepartment, salary);

        if (employees.size() >= MAXIMUM_NUMBER_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("В фирме уже есть данный сотрудник");
        }

        employees.put(employee.getFullName(), employee);

        return employee;
    }

    public Employee getEmployee(String firstName, String lastName) {

        String key = firstName + " " + lastName;

        Employee employee = employees.get(key);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {

        String key = firstName + " " + lastName;

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }

        return employees.remove(key);
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }
}
