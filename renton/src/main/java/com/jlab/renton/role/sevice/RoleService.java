package com.jlab.renton.role.sevice;

import java.util.List;

import com.jlab.renton.role.vo.RoleVo;

public interface RoleService {

	public RoleVo findByRoleId(String roleId);
	
	public List<RoleVo> findRoles();
	
	public List<RoleVo> findUserRole(String userId);
	
	public void insertRole(RoleVo roleVo);
	
	public void updateRole(RoleVo roleVo);
	
	public void deleteRole(String roleId);
}
