package com.jlab.renton.acl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlab.renton.acl.vo.AclVo;

@Repository
public interface AclDao {

	public List<AclVo> findByGroupNDomain(AclVo aclVo);
}
