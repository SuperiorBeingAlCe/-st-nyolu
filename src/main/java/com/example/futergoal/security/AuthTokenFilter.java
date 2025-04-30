package com.example.futergoal.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.futergoal.service.abstracts.CustomUserDetailsService;

import java.io.IOException;
import java.util.Optional;

@Component
public class AuthTokenFilter extends OncePerRequestFilter{
	@Autowired
    private JwtUtil jwtUtils;
	
	 @Autowired
	    private CustomUserDetailsService userDetailsService;
	 
	 @Override
	    protected void doFilterInternal(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            FilterChain filterChain
	    ) throws ServletException, IOException {
	        try {
	        	 Optional<String> jwt = parseJwt(request);
	        	 if (jwt.isPresent() && jwtUtils.validateJwtToken(jwt.get())) {
	                 String username = jwtUtils.getUsernameFromToken(jwt.get());
	                 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	                 UsernamePasswordAuthenticationToken authentication =
	                         new UsernamePasswordAuthenticationToken(
	                                 userDetails,
	                                 null,
	                                 userDetails.getAuthorities()
	                         );
	                 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                 SecurityContextHolder.getContext().setAuthentication(authentication);
	             }
	        } catch (Exception e) {
	            System.out.println("Cannot set user authentication: " + e);
	        }
	        filterChain.doFilter(request, response);
	    }
	 private Optional<String> parseJwt(HttpServletRequest request) {
		    String headerAuth = request.getHeader("Authorization");
		    if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
		        return Optional.of(headerAuth.substring(7));
		    }
		    return Optional.empty();
	    }

}
