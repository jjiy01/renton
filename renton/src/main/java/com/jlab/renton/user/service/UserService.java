package com.jlab.renton.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jlab.renton.user.vo.UserVo;

public interface UserService {

	public UserVo findUserById(String userId);
	
	public List<UserVo> findUsers();
	
	public void insertUser(UserVo userVo);
	
	public void updateUser(UserVo userVo);
	
	public void deleteUser(String userId);
}
