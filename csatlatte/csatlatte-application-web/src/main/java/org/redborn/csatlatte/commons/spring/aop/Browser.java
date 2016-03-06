package org.redborn.csatlatte.commons.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 지원 브라우저를 확인합니다.
 * 
 * IE 10 이하 브라우저는 지원하지 않아 브라우저 지원 페이지를 출력 합니다.
 * 
 */
public class Browser {
	
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	public Object supportBrowser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return isLessThenMSIE10(httpServletRequestValue.getUserAgent()) ? TilesName.ERROR_BROWSER : proceedingJoinPoint.proceed(); 
	}
	
	private boolean isLessThenMSIE10(String userAgent) {
		boolean result = false;
		userAgent = userAgent.toLowerCase();
		int msieIndexOf = userAgent.indexOf("msie");
		if (msieIndexOf >= 0) {
			String version = userAgent.substring(userAgent.indexOf("msie") + 5);
			version = version.substring(0, version.indexOf(";"));
			if (Float.parseFloat(version) < 11f) {
				result = true;
			}
		}
		return result;
	}

}