package com.jlab.renton.acl.service;

import java.util.List;

import com.jlab.renton.acl.vo.AclVo;

public interface AclService {

	public List<AclVo> findByGroupNDomain(String roleName, String domainName);
}
