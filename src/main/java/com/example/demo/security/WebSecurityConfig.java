package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebSecurityConfig {

	@Autowired
	private AuthEntryPointJwt  authorizedHandler;
	
	@Autowired
	private UserDetailsService userDetailsSergice;
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(authorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				//.antMatchers("/api/auth/**").permitAll().antMatchers("/api/test/**").permitAll() //No hace falta porque todos deben autenticarse
				.anyRequest().authenticated();

		http.addFilterBefore(autenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
	
	

	@Bean
	public AuthTokenFilter autenticationJwtFilter() {
		return  new AuthTokenFilter();
	}

	
	

}