package com.pfa.pack.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public SecurityConfig(final UserDetailsService userDetailsService, final BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(this.bCryptPasswordEncoder);
	}
	*/
	
	private DataSource dataSource;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public SecurityConfig(DataSource dataSource, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.dataSource = dataSource;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery("SELECT username, password, enabled FROM user_credentials WHERE LOWER(username) = ?")
			.authoritiesByUsernameQuery("SELECT username, UPPER(role) FROM user_credentials WHERE LOWER(username) = ?")
			.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("**/css/**").hasAnyRole("EMP", "MGR", "ADMIN")
			.antMatchers("**/js/**").hasRole("ADMIN")
			.antMatchers("/app/api/**").hasAnyRole("EMP", "MGR", "ADMIN")
			// .antMatchers("/app/**").hasRole("ADMIN")
			.antMatchers("/app/**/employees/**").hasAnyRole("EMP", "ADMIN") // pay attention to roles here
			.antMatchers("/app/**/managers/**").hasAnyRole("MGR", "ADMIN")
			.antMatchers("/", "/app").permitAll()
		.and().formLogin();
	}
	
	
	
}









