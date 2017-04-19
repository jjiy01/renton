package com.jlab.renton.main.security;

import org.springframework.security.acls.domain.AbstractPermission;

public class RentonPermission extends AbstractPermission {

	public static final RentonPermission READ = new RentonPermission(1);
	public static final RentonPermission WRITE = new RentonPermission(1 << 1);
	
	protected RentonPermission(int mask) {
		super(mask);
	}
}
