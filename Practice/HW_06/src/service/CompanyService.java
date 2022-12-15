package service;

import model.Employee;
import repository.CompanyRepo;
import repository.impl.CompanyRepoImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CompanyService {
    CompanyRepo companyRepo = new CompanyRepoImpl();

//    hire - bir iyeni işçi əlavə olunur
//,    hireAll - List işçi əlavə olunur
//    fire(int count) - count sayda işçi işdən kənarlaşdırılır
//    List<Employee> getTopSalaryStaff(int count) - count qədər ən çox maaş alanlar
//    List<Employee> getLowestSalaryStaff(int count) - count qədər ən az maaş alanlar

    public void addEmployee(String name) {
        companyRepo.hireEmployee(name);
    }

    public void addEmployees(List<String> newStaff) {
        companyRepo.hireEmployees(newStaff);
    }

    public void removeEmployee(int count) {

        // валидацию сделать


        companyRepo.fireEmployees(count);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        System.out.println("TOP 3");
        return companyRepo.getTopSalaryStaff(count);
    }

    public void getAllEmployees() {
        companyRepo.getAllEmployees();
    }

    public LinkedHashMap<Integer, String> getEmployeesDetails() {
        return companyRepo.getEmployeesDetails();
    }
}
