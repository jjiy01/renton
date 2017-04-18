package com.jlab.renton.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jlab.renton.auth.service.AuthService;
import com.jlab.renton.role.sevice.RoleService;
import com.jlab.renton.role.vo.RoleVo;
import com.jlab.renton.user.vo.UserVo;

@Controller
@RequestMapping(value="/role")
public class RoleController {

	@Autowired
	protected RoleService roleService;
	
	@Autowired
	protected AuthService authService;
	
	@Autowired
	protected SessionRegistry sessionRegistry;
	
	@PreAuthorize("hasPermission('ROLE', 'READ')")
	@RequestMapping("")
	public String viewRoles(Model model) {
		model.addAttribute("roles", roleService.findRoles());
		return "role/viewRoles";
	}
	
	@PreAuthorize("hasPermission('ROLE', 'READ')")
	@RequestMapping(value = "/id/{roleId}")
	public String viewRole(@PathVariable String roleId, Model model) {
		model.addAttribute("role", roleService.findByRoleId(roleId));
		model.addAttribute("auths", authService.findAuths());
		return "role/viewRole";
	}
	
	@PreAuthorize("hasPermission('ROLE', 'WRITE')")
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertUserView(Model model) {
		model.addAttribute("auths", authService.findAuths());
		return "role/insertRole";
	}
	
	@PreAuthorize("hasPermission('ROLE', 'WRITE')")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertUser(RoleVo roleVo, Model model) {
		roleService.insertRole(roleVo);
		model.addAttribute("role", roleVo);
		return "role/viewRole";
	}
	
	@PreAuthorize("hasPermission('ROLE', 'WRITE')")
	@RequestMapping(value = "/update/{roleId}", method = RequestMethod.GET)
	public String updateUserView(@PathVariable String roleId, Model model) {
		model.addAttribute("role", roleService.findByRoleId(roleId));
		model.addAttribute("auths", authService.findAuths());
		return "role/updateRole";
	}
	
	@PreAuthorize("hasPermission('ROLE', 'WRITE')")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(RoleVo roleVo, Model model, Authentication auth) {
		roleService.updateRole(roleVo);
		model.addAttribute("role", roleVo);
		
		List<Object> principals = sessionRegistry.getAllPrincipals();
		List<SessionInformation> sessions;
		UserVo loginUser = (UserVo)auth.getPrincipal();
		
		for(Object principal : principals) {
			if(loginUser.getUserId().equals(((UserVo) principal).getUserId())) {
				continue;
			}
			
			sessions = sessionRegistry.getAllSessions(principal, false);
			
			for(SessionInformation si : sessions) {
				si.expireNow();
			}
		}
		return "role/viewRole";
	}
}
