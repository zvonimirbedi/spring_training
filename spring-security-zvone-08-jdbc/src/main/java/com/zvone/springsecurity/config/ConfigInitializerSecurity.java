package com.zvone.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfigInitializerSecurity extends WebSecurityConfigurerAdapter {

	// add a reference to our securit data source
	
	@Autowired
	private DataSource theSecurityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//add our users for in memory aute
/*		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(users.username("marry").password("test123").roles("EMPLOYEE", "MANAGER"));
		auth.inMemoryAuthentication().withUser(users.username("susan").password("test123").roles("EMPLOYEE", "MANAGER","ADMIN"));*/
		
		// use jdbc authenication
		
		auth.jdbcAuthentication().dataSource(theSecurityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()  // allow public access to home page
        .antMatchers("/employees").hasRole("EMPLOYEE")
        .antMatchers("/leaders/**").hasRole("MANAGER")
        .antMatchers("/systems/**").hasRole("ADMIN")
        .and()
        .formLogin()
        .loginPage("/myLoginPage")
        .loginProcessingUrl("/authenticateTheUser")
        .permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/")  // after logout then redirect to landing page (root)
        .permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/access-denied");
		

	}
	
	

}
