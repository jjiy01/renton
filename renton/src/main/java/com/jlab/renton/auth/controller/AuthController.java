package com.jlab.renton.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlab.renton.auth.service.AuthService;
import com.jlab.renton.auth.vo.AuthVo;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PreAuthorize("hasPermission('AUTH', 'READ')")
	@RequestMapping("")
	public String viewAuths(Model model) {
		model.addAttribute("auths", authService.findAuths());
		return "auth/viewAuths";
	}
	
	@PreAuthorize("hasPermission('AUTH', 'READ')")
	@RequestMapping("/popup")
	public String viewAuthsPopup(Model model) {
		model.addAttribute("auths", authService.findAuths());
		return "auth/viewAuthsPopup";
	}
	
	@PreAuthorize("hasPermission('AUTH', 'READ')")
	@RequestMapping("/id/{authId}")
	public String viewAuth(@PathVariable String authId, Model model) {
		model.addAttribute("auth", authService.findByAuthId(authId));
		return "auth/viewAuth";
	}
	
	@PreAuthorize("hasPermission('AUTH', 'WRITE')")
	@RequestMapping("/insert")
	public String insertAuth(AuthVo authVo, Model model) {
		authService.insertAuth(authVo);
		model.addAttribute("auth", authVo);
		return "auth/viewAuth";
	}
	
}
