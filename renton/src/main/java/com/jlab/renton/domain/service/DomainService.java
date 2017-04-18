package com.jlab.renton.domain.service;

import java.util.List;

import com.jlab.renton.domain.vo.DomainVo;

public interface DomainService {

public List<DomainVo> findDomains();
	
	public DomainVo findByDomainId(String domainId);
	
	public void insertDomain(DomainVo domainVo);
	
	public void updateDomain(DomainVo domainVo);
	
	public void deleteDomain(String domainId);
}
