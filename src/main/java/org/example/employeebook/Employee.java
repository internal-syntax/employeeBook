package org.example.employeebook;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int numberDepartment;
    private int salary;

    public Employee(String firstName, String lastName, int numberDepartment, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberDepartment = numberDepartment;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getNumberDepartment() {
        return numberDepartment;
    }

    public int getSalary() {
        return salary;
    }

    public void setNumberDepartment(int numberDepartment) {
        this.numberDepartment = numberDepartment;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return numberDepartment == employee.numberDepartment && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, numberDepartment, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberDepartment=" + numberDepartment +
                ", salary=" + salary +
                '}';
    }
}
