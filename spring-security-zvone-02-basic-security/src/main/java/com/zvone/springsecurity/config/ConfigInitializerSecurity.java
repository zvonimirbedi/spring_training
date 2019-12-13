package com.zvone.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class ConfigInitializerSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//add our users for in memory aute
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOEYEE"));
		auth.inMemoryAuthentication().withUser(users.username("marry").password("test123").roles("MANAGER"));
		auth.inMemoryAuthentication().withUser(users.username("susan").password("test123").roles("ADMIN"));
	}

}
