package com.jlab.renton.user.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jlab.renton.role.dao.RoleDao;
import com.jlab.renton.role.vo.RoleVo;
import com.jlab.renton.user.dao.UserDao;
import com.jlab.renton.user.vo.UserVo;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	protected UserDao userDao;
	
	@Autowired
	protected RoleDao roleDao;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo userVo = userDao.findByUserId(username);
		//return new User(userVo.getUserName(), userVo.getPassword(), new HashSet<GrantedAuthority>());
		
		if(userVo == null) {
			throw new UsernameNotFoundException("Invalid username/password.");
		}
		
		List<RoleVo> roles = roleDao.findUserRole(userVo.getUserId());
		HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		List<String> auths;
		
		if(roles != null) {
			for(RoleVo role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
		}
		
		userVo.setAuthorities(authorities);
		return userVo;
	}

}
