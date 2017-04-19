package com.jlab.renton.acl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlab.renton.acl.dao.AclDao;
import com.jlab.renton.acl.service.AclService;
import com.jlab.renton.acl.vo.AclVo;
import com.jlab.renton.domain.vo.DomainVo;
import com.jlab.renton.role.vo.RoleVo;

@Service("rentonAclService")
public class AclServiceImpl implements AclService {

	@Autowired
	private AclDao aclDao;
	
	@Override
	public List<AclVo> findByGroupNDomain(String roleName, String domainName) {
		AclVo aclVo = new AclVo();
		aclVo.setRole(new RoleVo());
		aclVo.setDomain(new DomainVo());
		aclVo.getRole().setRoleName(roleName);
		aclVo.getDomain().setDomainName(domainName);
		return aclDao.findByGroupNDomain(aclVo);
	}

}
