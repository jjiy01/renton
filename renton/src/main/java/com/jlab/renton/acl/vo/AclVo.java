package com.jlab.renton.acl.vo;

import com.jlab.renton.domain.vo.DomainVo;
import com.jlab.renton.role.vo.RoleVo;

public class AclVo {

	private String entryId;
	
	private int permission;
	
	private RoleVo role;
	
	private DomainVo domain;

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public RoleVo getRole() {
		return role;
	}

	public void setRole(RoleVo role) {
		this.role = role;
	}

	public DomainVo getDomain() {
		return domain;
	}

	public void setDomain(DomainVo domain) {
		this.domain = domain;
	}
}
