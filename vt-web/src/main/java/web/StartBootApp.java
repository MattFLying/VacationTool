package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main Boot class. This class should be execute to run application.
 * 
 * @author Mateusz Mucha
 *
 */
@EntityScan("db.entity")
@EnableJpaRepositories({ "db.operation.repository.*" })
@ComponentScan({ "web.*", "db.operation.repository.*" })
@SpringBootApplication
public class StartBootApp {
	public static void main(String[] args) {
		SpringApplication.run(StartBootApp.class, args);
	}
}
