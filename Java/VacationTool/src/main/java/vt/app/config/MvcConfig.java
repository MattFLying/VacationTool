package vt.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { 
		"vt.app.controller", "vt.app.services" 
})
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/VacationTool");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");

		return driverManagerDataSource;
	}
}