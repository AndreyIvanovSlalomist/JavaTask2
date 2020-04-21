package task2.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import static task2.config.FindProperty.getProperty;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        System.out.println("Создаем свой DataSours");
        String ip = getProperty("db.ip");
        String port = getProperty("db.port");
        String sid = getProperty("db.SID");
        String username = getProperty("db.username");
        String password = getProperty("db.Password");

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }

}
