package com.eduardo.backendproject.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.backendproject.controllers.dto.CredentialsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ServerErrorException;

//Se ejecutat por cada slicitud
public class UsernamePasswordAuthFilter extends OncePerRequestFilter {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private final UserAuthenticationProvider userAuthenticationProvider;

	public UsernamePasswordAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
		this.userAuthenticationProvider= userAuthenticationProvider;
	}

	
	@Override
	protected void doFilterInternal(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse htpHttpServletResponse, 
			FilterChain filtetChain) throws ServerErrorException, IOException, ServletException {
		
			if ("/v1.0/signIn".equals(httpServletRequest.getServletPath())
                && HttpMethod.POST.matches(httpServletRequest.getMethod())) {
            CredentialsDto credentialsDto = MAPPER.readValue(httpServletRequest.getInputStream(), CredentialsDto.class);

            try {
                SecurityContextHolder.getContext().setAuthentication(
                        userAuthenticationProvider.validateCredentials(credentialsDto));
            } catch (RuntimeException e) {
                SecurityContextHolder.clearContext();
                throw e;
            }
        }
		
		filtetChain.doFilter(httpServletRequest, htpHttpServletResponse);
	}
}
