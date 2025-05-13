package com.example.diemdanh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.diemdanh.service.implement.UserDetailsSV;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsSV userDetailsSV;
	
	@Autowired
	private JWTAuthFilter jwtAuthFilter;
	
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
    
    @Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(AbstractHttpConfigurer::disable)
					.cors(Customizer.withDefaults())
					.authorizeHttpRequests(
							request -> request.requestMatchers("/v1/auth/**", "/v1/public/**").permitAll()
												.requestMatchers("/v1/admin/**").hasAnyAuthority("ADMIN")
												.requestMatchers("/v1/user/**").hasAnyAuthority("USER")
												.requestMatchers("/v1/adminuser/**").hasAnyAuthority("ADMIN", "USER")
												.requestMatchers("/v1/teacher/**").hasAuthority("TEACHER")
												.anyRequest().authenticated()
						)
					.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authenticationProvider(authenticationProvider()).addFilterBefore(
							jwtAuthFilter, UsernamePasswordAuthenticationFilter.class
					)
				    .exceptionHandling(exception -> exception
				    		.accessDeniedHandler(accessDeniedHandler)
				    		.authenticationEntryPoint(authenticationEntryPoint));
		return httpSecurity.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsSV);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}