package com.jlab.renton.role.sevice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jlab.renton.role.dao.RoleDao;
import com.jlab.renton.role.sevice.RoleService;
import com.jlab.renton.role.vo.RoleVo;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	protected RoleDao roleDao;
	
	@Override
	public RoleVo findByRoleId(String roleId) {
		RoleVo roleVo = roleDao.findByRoleId(roleId);
		roleVo.setAuthorities(roleDao.findRoleAuth(roleId));
		return roleVo;
	}

	@Override
	public List<RoleVo> findRoles() {
		return roleDao.findRoles();
	}

	@Override
	@Transactional
	public void insertRole(RoleVo roleVo) {
		roleDao.insertRole(roleVo);
		insertRoleAuth(roleVo);
	}
	
	protected void insertRoleAuth(RoleVo roleVo) {
		if(roleVo.getAuthorities() == null) {
			return;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("roleId", roleVo.getRoleId());
		for(String auth : roleVo.getAuthorities()) {
			map.put("authId", auth);
			roleDao.insertRoleAuth(map);
		}
	}

	@Override
	@Transactional
	public void updateRole(RoleVo roleVo) {
		roleDao.updateRole(roleVo);
		roleDao.deleteRoleAuth(roleVo.getRoleId());
		insertRoleAuth(roleVo);
	}

	@Override
	@Transactional
	public void deleteRole(String roleId) {
		roleDao.deleteRoleAuth(roleId);
		roleDao.deleteRole(roleId);
	}

	@Override
	public List<RoleVo> findUserRole(String userId) {
		return roleDao.findUserRole(userId);
	}
}
