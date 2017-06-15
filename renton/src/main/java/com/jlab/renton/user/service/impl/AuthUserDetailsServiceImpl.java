package com.jlab.renton.user.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.jlab.renton.role.dao.RoleDao;
import com.jlab.renton.role.vo.RoleVo;
import com.jlab.renton.user.dao.UserDao;
import com.jlab.renton.user.vo.UserVo;

@Service("authUserDetailsService")
public class AuthUserDetailsServiceImpl implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

	@Autowired
	protected UserDao userDao;
	
	@Autowired
	protected RoleDao roleDao;
	
	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
		UserVo userVo = userDao.findByUserId((String) token.getPrincipal());
		//return new User(userVo.getUserName(), userVo.getPassword(), new HashSet<GrantedAuthority>());
		
		if(userVo == null) {
			throw new UsernameNotFoundException("Invalid username/password.");
		}
		
		List<RoleVo> roles = roleDao.findUserRole(userVo.getUserId());
		HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		List<String> auths;
		
		if(roles != null) {
			for(RoleVo role : roles) {
				auths = roleDao.findRoleAuthName(role.getRoleId());
				
				for(String auth : auths) {
					authorities.add(new SimpleGrantedAuthority(auth));
				}
			}
		}
		
		userVo.setAuthorities(authorities);
		return userVo;
	}

}
