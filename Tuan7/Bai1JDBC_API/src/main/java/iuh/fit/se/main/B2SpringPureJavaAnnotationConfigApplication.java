package iuh.fit.se.main;

import iuh.fit.se.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class B2SpringPureJavaAnnotationConfigApplication {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(B2SpringPureJavaAnnotationConfigApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection()); // Test kết nối

        // Gọi DAO ở đây nếu cần
    }
}

