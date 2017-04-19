package com.jlab.renton.main.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.jlab.renton.acl.service.AclService;
import com.jlab.renton.acl.vo.AclVo;

public class RentonPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private AclService aclService;
	
	@Autowired
	private PermissionFactory permissionFactory;
	
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		Permission perm = permissionFactory.buildFromName((String) permission);
		Collection<? extends GrantedAuthority> auths = authentication.getAuthorities();
		List<AclVo> aclList;
		
		for(GrantedAuthority auth : auths) {
			aclList = aclService.findByGroupNDomain(auth.getAuthority(), (String) targetDomainObject);
			
			if(aclList == null || aclList.size() == 0) {
				continue;
			}
			
			if((aclList.get(0).getPermission() & perm.getMask()) != 0) {
				return true;
			}
		}
		
		return false;
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
