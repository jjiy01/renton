package com.jlab.renton.main.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

public class RentonAccessDecisionVoter implements AccessDecisionVoter<Object> {

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication auth, Object object, Collection<ConfigAttribute> attributes) {
		System.out.println(auth);
		System.out.println(object);
		return ACCESS_DENIED;
	}

}
