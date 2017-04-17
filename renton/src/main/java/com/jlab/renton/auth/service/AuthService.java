package com.jlab.renton.auth.service;

import java.util.List;

import com.jlab.renton.auth.vo.AuthVo;

public interface AuthService {

	public List<AuthVo> findAuths();
	
	public AuthVo findByAuthId(String authId);
	
	public void insertAuth(AuthVo authVo);
	
	public void updateAuth(AuthVo authVo);
	
	public void deleteAuth(String authId);
}
