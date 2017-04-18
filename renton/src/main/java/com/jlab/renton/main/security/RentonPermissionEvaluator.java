package com.jlab.renton.main.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class RentonPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		System.out.println(authentication);
		System.out.println(targetDomainObject);
		System.out.println(permission);
		return true;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		System.out.println(authentication);
		System.out.println(targetId);
		System.out.println(targetType);
		return true;
	}

}
