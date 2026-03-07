package org.example.employeebook.service;

import org.example.employeebook.Employee;
import org.example.employeebook.exceptions.EmployeeAlreadyAddedException;
import org.example.employeebook.exceptions.EmployeeNotFoundException;
import org.example.employeebook.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private static final int MAXIMUM_NUMBER_OF_EMPLOYEES = 5;

    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAXIMUM_NUMBER_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        for (Employee emp : employees) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("В фирме уже есть такой сотрудник");
            }
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        return employee;
    }

    public Employee getEmployee(String firstName, String lastName) {
        for (Employee emp : employees) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee removeEmployee(String firstName, String lastName) {
        for (Employee emp : employees) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                employees.remove(emp);
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
