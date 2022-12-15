package Comparator;

import model.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getMonthSalary() - o2.getMonthSalary();

//        return o1.getMonthSalary() > o2.getMonthSalary() ? 1 : 0;
    }
}
