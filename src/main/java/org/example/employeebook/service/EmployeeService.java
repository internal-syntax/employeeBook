package org.example.employeebook.service;

import org.example.employeebook.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int MAXIMUM_NUMBER_OF_EMPLOYEES = 5;

    private final List<Employee> employees = new ArrayList<>();
}
