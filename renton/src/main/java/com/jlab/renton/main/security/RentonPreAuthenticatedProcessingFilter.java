package com.jlab.renton.main.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class RentonPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		String rentonUser = request.getHeader("RENTON_USER");
		
		if(rentonUser != null) {
			return rentonUser;
		}
		
		return "";
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return "";
	}

}
