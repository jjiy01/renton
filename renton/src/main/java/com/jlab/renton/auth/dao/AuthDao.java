package com.jlab.renton.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlab.renton.auth.vo.AuthVo;

@Repository
public interface AuthDao {

	public List<AuthVo> findAuths();
	
	public AuthVo findByAuthId(String authId);
	
	public void insertAuth(AuthVo authVo);
	
	public void updateAuth(AuthVo authVo);
	
	public void deleteAuth(String authId);
}
