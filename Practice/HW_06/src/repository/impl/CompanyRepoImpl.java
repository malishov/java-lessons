package repository.impl;

import model.Company;
import model.Employee;
import repository.CompanyRepo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CompanyRepoImpl implements CompanyRepo {

    private Company company = new Company("Cirtdan MMC", LocalDate.now());

    @Override
    public void findAllEmployee() {
        company.getEmployees();
    }

    @Override
    public void hireEmployee(String name) {
        company.hire(name);
    }

    @Override
    public void hireEmployees(List<String> newStaff) {
        company.hireAll(newStaff);
    }

    @Override
    public void fireEmployees(int count) {
        company.fire(count);
    }

    @Override
    public void getAllEmployees() {
        List<Employee> tmpEmp = company.getEmployees();

        System.out.println("All Employees:");

        for (Employee e : tmpEmp)
            System.out.println(e.getName());
    }

    @Override
    public LinkedHashMap<Integer, String> getEmployeesDetails() {
        return company.getEmployeesDetails();
    }


    @Override
    public List<Employee> getTopSalaryStaff(int count) {
        return company.getTopSalaryStaff(count);
    }
}
