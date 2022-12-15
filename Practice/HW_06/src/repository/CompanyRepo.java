package repository;

import model.Employee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface CompanyRepo {
    void findAllEmployee();
    void hireEmployee(String name);
    void hireEmployees(List<String> newStaff);

    void fireEmployees(int count);

    void getAllEmployees();

    LinkedHashMap<Integer, String> getEmployeesDetails();

    List<Employee> getTopSalaryStaff(int count);
}
