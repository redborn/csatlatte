package org.redborn.csatlatte.commons.spring.web.multipart.commons;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 수능라떼의 miltipart 입니다.
 * 
 * @author 최순열
 *
 */
public class CsatMultipartResolver extends CommonsMultipartResolver {
	
	/**
	 * multipart 여부를 판단합니다.
	 * enctype이 multipart/form-data 일 경우 multipart로 판단합니다.
	 * 
	 * @param request 
	 * @return multipart 여부
	 */
	@Override
	public boolean isMultipart(HttpServletRequest request) {
		boolean result = false;
		if (request != null) {
			String contentType = request.getContentType();
			result = contentType != null && contentType.toLowerCase().startsWith("multipart/form-data");
		}
		return result;
	}

}