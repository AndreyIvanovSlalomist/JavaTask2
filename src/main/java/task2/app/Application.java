package task2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "task2")
@EnableJpaRepositories(basePackages = "task2.repositories")
@ConfigurationProperties("task2.properties")
@EntityScan(basePackages = "task2.models")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }


}
