package com.jlab.renton.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlab.renton.domain.dao.DomainDao;
import com.jlab.renton.domain.service.DomainService;
import com.jlab.renton.domain.vo.DomainVo;

@Service("domainService")
public class DomainServiceImpl implements DomainService {

	@Autowired
	protected DomainDao domainDao;
	
	@Override
	public List<DomainVo> findDomains() {
		return domainDao.findDomains();
	}

	@Override
	public DomainVo findByDomainId(String domainId) {
		return domainDao.findByDomainId(domainId);
	}

	@Override
	public void insertDomain(DomainVo domainVo) {
		domainDao.insertDomain(domainVo);
	}

	@Override
	public void updateDomain(DomainVo domainVo) {
		domainDao.updateDomain(domainVo);
	}

	@Override
	public void deleteDomain(String domainId) {
		domainDao.deleteDomain(domainId);
	}
}
