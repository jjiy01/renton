package com.jlab.renton.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlab.renton.user.service.UserService;
import com.jlab.renton.user.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasAuthority('USER_WRITE')")
	@RequestMapping(value = "/insert", consumes = "application/x-www-form-urlencoded")
	public String insertUser(UserVo userVo, Model model) {
		userService.insertUser(userVo);
		model.addAttribute("user", userVo);
		return "user/viewUser";
	}
	
	@PreAuthorize("hasAuthority('USER_WRITE')")
	@RequestMapping(value = "/insert", consumes = "application/json")
	public @ResponseBody Map<String, String> insertUserJson(@RequestBody UserVo userVo) {
		userService.insertUser(userVo);
		/*if(true) {
			throw new RuntimeException("aaa");
		}*/
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "0");
		result.put("message", "success");
		return result;
	}
	
	@PreAuthorize("hasAuthority('USER_WRITE')")
	@RequestMapping("/update")
	public String updateUser(UserVo userVo, Model model) {
		userService.updateUser(userVo);
		model.addAttribute("user", userVo);
		return "user/viewUser";
	}
	
	@PreAuthorize("hasAuthority('USER_WRITE')")
	@RequestMapping("/delete")
	public String deleteUser(String userId) {
		userService.deleteUser(userId);
		return "redirect:user/viewall";
	}
	
	@PreAuthorize("hasAuthority('USER_READ')")
	@RequestMapping("")
	public String viewUsers(Model model) {
		model.addAttribute("users", userService.findUsers());
		return "user/viewUsers";
	}
	
	@PreAuthorize("hasAuthority('USER_READ')")
	@RequestMapping("/id/{userId}")
	public String viewUser(@PathVariable String userId, Model model) {
		model.addAttribute("user", userService.findUserById(userId));
		return "user/viewUser";
	}
}
