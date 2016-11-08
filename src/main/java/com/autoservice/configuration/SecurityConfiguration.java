package com.autoservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Spring Security ignores request to static resources such as CSS or JS files.
        web.ignoring()
                .antMatchers(
                        "/error/**",
                        "/css/**",
                        "/img/**",
                        "/js/**",
                        "/fonts/**",
                        "/favicon.ico"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/contractors/**").access("hasRole('CLIENT_ROLE')")
                .and().formLogin()
                .usernameParameter("email").passwordParameter("password")
                .and().logout().logoutSuccessUrl("/")
                .and().exceptionHandling().authenticationEntryPoint(new Http401AuthenticationEntryPoint(""))
                .and().csrf().disable();
    }
}
