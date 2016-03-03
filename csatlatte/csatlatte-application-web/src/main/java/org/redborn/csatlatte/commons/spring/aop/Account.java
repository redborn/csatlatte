package org.redborn.csatlatte.commons.spring.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.UriService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * \\/{id}/.... 영역에 접근하였을 경우 로그인 된 ID와 일치 여부를 확인합니다.
 * 
 * 일치하지 않을 경우 404 페이지로 이동 합니다.
 * 
 * @author 최순열
 *
 */
public class Account {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UriService uriService;
	@Autowired
	private HttpSessionValue httpSessionValue; 
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	public Object compareId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String requestURI = request.getRequestURI();
		int contextPathLength = request.getContextPath().length();
		int endIndex = requestURI.indexOf("/", contextPathLength + 1);
		if (endIndex < 0) {
			endIndex = requestURI.length();
		}
		Object result = TilesName.ERROR_404;
		if (requestURI.substring(contextPathLength + 1, endIndex).equals(httpSessionValue.getId())) {
			result = proceedingJoinPoint.proceed();
			uriService.connection(new StringBuilder("/{id}").append(requestURI.substring(endIndex)).toString(), httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp());
		}
		return result;
	}

}