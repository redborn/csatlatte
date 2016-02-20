package org.redborn.csatlatte.commons.servlet.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

public class HttpServletUtils {
	
	private static HttpServletUtils HTTP_SERVLET_UTILS;
	
	private HttpServletUtils() {};
	
	public static HttpServletUtils getInstance() {
		if (HTTP_SERVLET_UTILS == null) {
			HTTP_SERVLET_UTILS = new HttpServletUtils();
		}
		return HTTP_SERVLET_UTILS;
	}
	
	/**
	 * mime을 구합니다.
	 * 
	 * @param extension 확장자
	 * @return mine
	 */
	public String getMime(String extension) {
		Properties properties = new Properties();
		try {
			properties.load(new BufferedInputStream(this.getClass().getResourceAsStream("/org/redborn/csatlatte/commons/servlet/http/mime.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return properties.getProperty(extension.toLowerCase(), "application/octet-stream");
	}

}
