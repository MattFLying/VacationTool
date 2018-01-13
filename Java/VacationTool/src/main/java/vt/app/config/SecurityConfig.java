package vt.app.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	VtAuthenticationSuccessHandler vtAuthenticationSuccessHandler;
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) {
		try {
			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
					.usersByUsernameQuery("select emp_evidenceNumber,emp_password,emp_enabled from vt_employee where emp_evidenceNumber=?")
					.authoritiesByUsernameQuery("select emp_evidenceNumber,emp_role from vt_employee where emp_evidenceNumber=?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index", "/css/**", "/core/**", "/js/**", "/img/**").permitAll()
		.antMatchers("/a/**").access("hasRole('" + UserRole.ROLE_ADMIN + "')")
		.antMatchers("/e/**").access("hasRole('" + UserRole.ROLE_EMPLOYEE + "')")
		.antMatchers("/m/**").access("hasRole('" + UserRole.ROLE_MANAGER + "')").anyRequest()
		.authenticated().and().formLogin()
		.loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
		.successHandler(vtAuthenticationSuccessHandler).and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/failure");

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}