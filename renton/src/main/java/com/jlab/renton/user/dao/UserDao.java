package com.jlab.renton.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlab.renton.user.vo.UserVo;

@Repository
public interface UserDao {

	public UserVo findByUserId(String userId);
	
	public List<UserVo> findUsers();
	
	public void insertUser(UserVo userVo);
	
	public void updateUser(UserVo userVo);
	
	public void deleteUser(String userId);
}
