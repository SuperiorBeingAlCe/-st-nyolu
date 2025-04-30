package com.example.futergoal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration	
public class SecurityConfig  {
	  @Autowired
	    CustomUserDetailsService userDetailsService;
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
	        // Updated configuration for Spring Security 6.x
	        http
	                .csrf(csrf -> csrf.disable()) // Disable CSRF
	                .cors(cors -> cors.disable()) // Disable CORS (or configure if needed)
	                .exceptionHandling(exceptionHandling ->
	                        exceptionHandling.authenticationEntryPoint(unauthorizedHandler)
	                )
	                .sessionManagement(sessionManagement ->
	                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                )
	                .authorizeHttpRequests(authorizeRequests ->
	                        authorizeRequests
	                                .requestMatchers("/api/auth/**", "/api/test/all").permitAll() // Use 'requestMatchers' instead of 'antMatchers'
	                                .anyRequest().authenticated()
	                );
	        // Add the JWT Token filter before the UsernamePasswordAuthenticationFilter
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

}
