package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Boot class. This class should be execute to run application.
 * 
 * @author Mateusz Mucha
 *
 */
@ComponentScan({ "web.*", "db.*" })
@SpringBootApplication
public class StartBootApp {
	public static void main(String[] args) {
		SpringApplication.run(StartBootApp.class, args);
	}
}
