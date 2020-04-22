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

        String dbType = getProperty("db.Type");
        return DataSourceBuilder.create()
                .driverClassName(geDriverClassName(dbType))
                .url(getUrl(dbType))
                .username(getProperty("db.username"))
                .password(getProperty("db.Password")).build();
    }

    private String getUrl(String dbType) {

        String ip = getProperty("db.ip");
        String port = getProperty("db.port");
        String baseName = getProperty("db.baseName.SID");
        if (ip.equals("") || port.equals("") || baseName.equals("")) {
            return getProperty("db.url");
        }
        switch (dbType) {
            case "mysql":
                return "jdbc:mysql://" + ip + ":" + port + "/" + baseName;
            case "oracle":
                return "jdbc:oracle:thin:@" + ip + ":" + port + ":" + baseName;
            case "postgresql":
                return "jdbc:postgresql://" + ip + ":" + port + "/" + baseName;
            default:
                return getProperty("db.url");
        }
    }

    private String geDriverClassName(String dbType) {
        switch (dbType) {
            case "mysql":
                return "com.mysql.jdbc.Driver";
            case "oracle":
                return "oracle.jdbc.driver.OracleDriver";
            case "postgresql":
                return "org.postgresql.Driver";
            default:
                return getProperty("db.driverClassName");
        }
    }
}
