package org.redborn.csatlatte.commons.spring.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.UriService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * URI 접속 처리를 합니다.
 * 
 * @author 최순열
 *
 */
public class Uri {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UriService uriService;
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	public Object connection(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return uriService.connection(request.getRequestURI().substring(request.getContextPath().length()), httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp()) ? proceedingJoinPoint.proceed() : TilesName.ERROR_500;
	}

}