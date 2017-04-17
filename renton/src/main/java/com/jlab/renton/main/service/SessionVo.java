package com.jlab.renton.main.service;

import java.util.List;

import org.springframework.security.core.session.SessionInformation;

public class SessionVo {

	private Object principal;
	
	private List<SessionInformation> sessions;

	public Object getPrincipal() {
		return principal;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

	public List<SessionInformation> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionInformation> sessions) {
		this.sessions = sessions;
	}
}
