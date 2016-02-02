package org.redborn.csatlatte.commons.spring.security.authentication;

import java.util.ArrayList;
import java.util.List;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CsatAuthenticationProvider implements AuthenticationProvider {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String id = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		StudentVo studentVo = studentService.information(id, password);
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
		
		if (studentVo != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			if (studentVo.getRuleSequence() == HttpSessionValue.MANAGER) {
				grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(id, password, grantedAuthorities);
			httpSessionValue.setUser(id, studentVo.getStudentSequence(), studentVo.getNickname(), studentVo.getRuleSequence(), studentVo.getCsatSequence());
			logger.info(new StringBuilder("login success. ID is ").append(studentVo.getStudentId()).toString());
		}
		
		return usernamePasswordAuthenticationToken;
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}

}
