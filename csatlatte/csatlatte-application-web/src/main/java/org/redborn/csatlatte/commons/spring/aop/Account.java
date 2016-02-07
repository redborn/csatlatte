package org.redborn.csatlatte.commons.spring.aop;

import javax.servlet.http.HttpServletRequest;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
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
	private HttpSessionValue httpSessionValue; 
	
	public Object compareId() {
		String requestURI = request.getRequestURI();
		int contextPathLength = request.getContextPath().length();
		int endIndex = requestURI.indexOf("/", contextPathLength + 1);
		if (endIndex < 0) {
			endIndex = requestURI.length();
		}
		return requestURI.substring(contextPathLength + 1, endIndex).equals(httpSessionValue.getId()) ? null: TilesName.ERROR_404;
	}

}