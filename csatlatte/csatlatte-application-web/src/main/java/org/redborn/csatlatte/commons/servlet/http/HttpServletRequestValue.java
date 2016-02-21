package org.redborn.csatlatte.commons.servlet.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpServletRequestValue {
	
	@Autowired
	private HttpServletRequest request;
	
	public String getSessionId() {
		return request.getSession().getId();
	}
	
	public String getIp() {
		return request.getRemoteAddr();
	}
	
	public String getUserAgent() {
		return request.getHeader("User-Agent");
	}
	
}