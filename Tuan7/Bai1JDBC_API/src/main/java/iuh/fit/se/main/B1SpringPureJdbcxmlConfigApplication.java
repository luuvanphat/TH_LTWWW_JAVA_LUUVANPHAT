package iuh.fit.se.main;

import iuh.fit.se.dao.daoImpl.EmployeeDAOImpl;
import iuh.fit.se.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class B1SpringPureJdbcxmlConfigApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(B1SpringPureJdbcxmlConfigApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());

        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        dao.setDataSource((DataSource) context.getBean("dataSource"));

        Employee emp = new Employee(1, "Dev", "Luu Van Phat");
        dao.save(emp);

        System.out.println("Lưu thành công");
    }

}
