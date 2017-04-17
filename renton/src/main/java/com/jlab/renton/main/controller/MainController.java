package com.jlab.renton.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;

import com.jlab.renton.main.service.SessionVo;

@Controller
public class MainController {

	@Autowired
	protected SessionRegistry sessionRegistry; 

	@ModelAttribute
	public SessionInformation getSessionId() {
		return sessionRegistry.getSessionInformation(RequestContextHolder.getRequestAttributes().getSessionId());
	}
	
	@RequestMapping("/main")
	public String viewMain() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "main";
	}
	
	@RequestMapping("/sessions")
	public String viewSessions(Model model) {
		List<Object> principals = sessionRegistry.getAllPrincipals();
		List<SessionVo> sessions = new ArrayList<SessionVo>();
		
		for(Object principal : principals) {
			SessionVo sessionVo = new SessionVo();
			sessionVo.setPrincipal(principal);
			sessionVo.setSessions(sessionRegistry.getAllSessions(principal, false));
			sessions.add(sessionVo);
		}
		
		model.addAttribute("sessions", sessions);
		return "sessions";
	}
}
