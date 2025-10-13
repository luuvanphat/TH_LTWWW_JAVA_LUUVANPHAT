package iuh.fit.se.main;

import iuh.fit.se.dao.EmployeeDAO;
import iuh.fit.se.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.dao", "iuh.fit.se.dao.daoImpl", "iuh.fit.se.entities"})
public class B3SpringPureJdbcAutoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(B3SpringPureJdbcAutoConfigApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO) {
        return args -> {
            // Thêm nhân viên mới
            Employee employee = new Employee("Dev", "Luu Van Thi");
            employeeDAO.save(employee);

            // In tất cả nhân viên
            List<Employee> employees = employeeDAO.getAll();
            employees.forEach(System.out::println);

            // Lấy nhân viên theo ID
            Employee employee2 = employeeDAO.getById(1);
            System.out.println("Tìm theo ID: " + employee2);
        };
    }
}
