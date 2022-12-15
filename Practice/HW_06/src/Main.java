import model.Employee;
import model.Operator;
import service.CompanyService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // UI.run()
        CompanyService companyService = new CompanyService();

        companyService.addEmployee("Murad");
        companyService.addEmployee("Murad2");
        companyService.addEmployee("Murad3");
        companyService.addEmployee("Murad4");
        companyService.addEmployees(Arrays.asList("Murad5", "Murad6", "murad7"));
//        companyService.getAllEmployees();

        List<Employee> topEmployees = companyService.getTopSalaryStaff(3);

        for (Employee e : topEmployees)
            System.out.println(e.getName() + " " + e.getMonthSalary());


//        companyService.getAllEmployees();
//
//        System.out.println(companyService.getEmployeesDetails());

//        Task3();
    }

    public static void Task3() {
//        Doğum tarixini qəbul edib bütün ad günlərinin həftənin hansı günlərinə düşdüyünü çap etmək


        String input = "1998-10-10";

        LocalDate DOB = LocalDate.of(1998, 10, 10);

        for (int i = 1998; i <= LocalDate.now().getYear(); i++) {
            System.out.println(i + " " + DOB.getDayOfWeek());
        }

    }
}