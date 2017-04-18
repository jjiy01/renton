package com.jlab.renton.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlab.renton.user.service.UserService;
import com.jlab.renton.user.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasPermission('USER', 'WRITE')")
	@RequestMapping(value = "/insert")
	public String insertUser(UserVo userVo, Model model) {
		userService.insertUser(userVo);
		model.addAttribute("user", userVo);
		return "user/viewUser";
	}
	
	@PreAuthorize("hasPermission('USER', 'WRITE')")
	@RequestMapping("/update")
	public String updateUser(UserVo userVo, Model model) {
		userService.updateUser(userVo);
		model.addAttribute("user", userVo);
		return "user/viewUser";
	}
	
	@PreAuthorize("hasPermission('USER', 'WRITE')")
	@RequestMapping("/delete")
	public String deleteUser(String userId) {
		userService.deleteUser(userId);
		return "redirect:user/viewall";
	}
	
	@PreAuthorize("hasPermission('USER', 'READ')")
	@RequestMapping("")
	public String viewUsers(Model model) {
		model.addAttribute("users", userService.findUsers());
		return "user/viewUsers";
	}
	
	@PreAuthorize("hasPermission('USER', 'READ')")
	@RequestMapping("/id/{userId}")
	public String viewUser(@PathVariable String userId, Model model) {
		model.addAttribute("user", userService.findUserById(userId));
		return "user/viewUser";
	}
}
