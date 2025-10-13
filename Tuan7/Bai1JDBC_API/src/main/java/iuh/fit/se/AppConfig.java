package iuh.fit.se;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Value("${app.datasource.url}")
    private String url;

    @Value("${app.datasource.username}")
    private String userName;

    @Value("${app.datasource.password}")
    private String password;

    @Value("${app.datasource.driver}")
    private String driver;

    @Bean(name = "dataSource")
    DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setDriverClassName(driver);

        return driverManagerDataSource;
    }
}

