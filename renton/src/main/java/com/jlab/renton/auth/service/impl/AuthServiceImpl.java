package com.jlab.renton.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlab.renton.auth.dao.AuthDao;
import com.jlab.renton.auth.service.AuthService;
import com.jlab.renton.auth.vo.AuthVo;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDao authDao;
	
	@Override
	public List<AuthVo> findAuths() {
		return authDao.findAuths();
	}

	@Override
	public AuthVo findByAuthId(String authId) {
		return authDao.findByAuthId(authId);
	}

	@Override
	public void insertAuth(AuthVo authVo) {
		authDao.insertAuth(authVo);
	}

	@Override
	public void updateAuth(AuthVo authVo) {
		authDao.updateAuth(authVo);
	}

	@Override
	public void deleteAuth(String authId) {
		authDao.deleteAuth(authId);
	}

}
