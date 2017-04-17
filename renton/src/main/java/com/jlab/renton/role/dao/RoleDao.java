package com.jlab.renton.role.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jlab.renton.role.vo.RoleVo;

@Repository
public interface RoleDao {

	public RoleVo findByRoleId(String roleId);
	
	public List<RoleVo> findRoles();
	
	public List<String> findRoleAuth(String roleId);
	
	public List<String> findRoleAuthName(String roleId);
	
	public List<RoleVo> findUserRole(String userId);
	
	public void insertRole(RoleVo roleVo);
	
	public void updateRole(RoleVo roleVo);
	
	public void deleteRole(String roleId);
	
	public void insertRoleAuth(Map<String, String> param);
	
	public void deleteRoleAuth(String roleId);
}
