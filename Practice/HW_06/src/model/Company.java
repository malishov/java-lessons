package model;

import Comparator.EmployeeSalaryComparator;

import java.time.LocalDate;
import java.util.*;

public class Company {

    private String name;
    private List<Employee> employees = new ArrayList<>();
    private LocalDate dateOfFoundation;

    public Company(String name, LocalDate dateOfFoundation) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
    }

    public void hire(String name) {
        Employee tmpEmployee = new Operator(name);
        this.employees.add(tmpEmployee);
    }

    public void hireAll(List<String> newStaff) {

        for (String str : newStaff)
            employees.add(new Operator(str));
    }

    public void fire(int count) {

        while(count > 0) {
            employees.remove(employees.size() - 1);
            count--;
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> tmpEmp = new ArrayList<>();

        Collections.sort(employees, new EmployeeSalaryComparator());

        for (int i = 0; i < count; i++) {
//            System.out.println(employees.get(i).getName() + " " + employees.get(i).getMonthSalary());
            tmpEmp.add(employees.get(i));
        }

        // !!!!!!!!!!!!
        return tmpEmp;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return null;
    }

    // Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public List<Employee> getEmployees() {

        return employees;
    }

    public LinkedHashMap<Integer, String> getEmployeesDetails() {

        LinkedHashMap<Integer, String> employeeDetails = new LinkedHashMap<>();

        for (Employee e : employees) {
            System.out.println(e.getName() + " " + e.getMonthSalary());
            employeeDetails.put(e.getMonthSalary(), e.getName());
        }
        return employeeDetails;
    }
}
