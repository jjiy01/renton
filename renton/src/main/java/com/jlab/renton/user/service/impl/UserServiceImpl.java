package com.jlab.renton.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlab.renton.user.dao.UserDao;
import com.jlab.renton.user.service.UserService;
import com.jlab.renton.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserVo findUserById(String userId) {
		UserVo userVo = userDao.findByUserId(userId);
		return userVo;
	}

	@Override
	public List<UserVo> findUsers() {
		return userDao.findUsers();
	}

	@Override
	public void insertUser(UserVo userVo) {
		userDao.insertUser(userVo);
	}

	@Override
	public void updateUser(UserVo userVo) {
		userDao.updateUser(userVo);
	}

	@Override
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
	}

}
