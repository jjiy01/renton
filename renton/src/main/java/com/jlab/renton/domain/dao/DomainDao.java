package com.jlab.renton.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlab.renton.domain.vo.DomainVo;

@Repository
public interface DomainDao {

	public List<DomainVo> findDomains();
	
	public DomainVo findByDomainId(String domainId);
	
	public void insertDomain(DomainVo domainVo);
	
	public void updateDomain(DomainVo domainVo);
	
	public void deleteDomain(String domainId);
}
