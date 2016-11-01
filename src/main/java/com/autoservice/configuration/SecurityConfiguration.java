package com.autoservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("client").password("client").roles("client");
		auth.inMemoryAuthentication().withUser("contr").password("contr").roles("cont");
		//auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
	  	.antMatchers("/", "/home").permitAll() 
		.antMatchers("/clients/**").access("hasRole('client')").and().formLogin().loginPage("/login")
			  .usernameParameter("email").passwordParameter("password")
			  .and().csrf()
			  .and().exceptionHandling().accessDeniedPage("/Access_Denied");
 
	}
}
