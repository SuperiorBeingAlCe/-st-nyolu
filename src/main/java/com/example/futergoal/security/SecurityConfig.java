package com.example.futergoal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.futergoal.service.abstracts.AuthService;

@Configuration	
public class SecurityConfig  {
	 
	 @Autowired
	    AuthService userDetailsService;
	    @Autowired
	    private AuthEntryPointJwt unauthorizedHandler;
	    @Bean
	    public AuthTokenFilter authenticationJwtTokenFilter() {
	        return new AuthTokenFilter();
	    }
	    @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration authenticationConfiguration
	    ) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	       
	        http
	                .csrf(csrf -> csrf.disable()) 
	                .cors(cors -> cors.disable()) 
	                .exceptionHandling(exceptionHandling ->
	                        exceptionHandling.authenticationEntryPoint(unauthorizedHandler)
	                )
	                .sessionManagement(sessionManagement ->
	                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                )
	                .authorizeHttpRequests(authorizeRequests ->
	                        authorizeRequests
	                                .requestMatchers("/rest/api/user/save", "/api/test/all", "/api/auth/signin").permitAll() 
	                                .anyRequest().authenticated()
	               )
	                .authenticationProvider(authenticationProvider());
	        
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);  
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	    
	    //--------------------
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

}
