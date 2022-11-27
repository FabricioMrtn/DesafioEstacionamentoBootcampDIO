package com.fabriciomrtn.github.Estacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user")
		.password(passEncoder().encode("Esquilo97"))
		.roles("USER")
		.and().passwordEncoder(passEncoder());
	}
	
	@Bean 
	private PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/swagger-resources/**").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/v2/api-docs/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/csrf").permitAll()
		.antMatchers("/*.js").permitAll()
		.antMatchers("/*.css").permitAll()
		.antMatchers("/*.ico").permitAll()
		.antMatchers("/*.png").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
}
