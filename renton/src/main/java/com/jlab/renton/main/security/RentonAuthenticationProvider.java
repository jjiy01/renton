package com.jlab.renton.main.security;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jlab.renton.role.sevice.RoleService;

@Component
public class RentonAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	protected UserDetailsService userDetailsService;
	
	@Autowired
	protected RoleService authService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(token.getName());
		
		if(userDetails == null) {
			throw new UsernameNotFoundException("Invalid username/password");
		}
		
		if(userDetails.getPassword().equals(authentication.getCredentials()) == false) {
			throw new BadCredentialsException("Invalid username/password");
		}
		
		
		
		return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), new HashSet<GrantedAuthority>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
