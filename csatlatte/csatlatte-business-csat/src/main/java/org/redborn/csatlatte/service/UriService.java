package org.redborn.csatlatte.service;

/**
 * URI서비스입니다.
 */
public interface UriService {
	
	/**
	 * URI 접속입니다.
	 * 
	 * @param uri
	 * @param userAgent 사용자 기기
	 * @param sessionId 사용자 아이디
	 * @param ip 사용자 아이피
	 * @return 접속 성공 여부
	 */
	public boolean connection(String uri, String userAgent, String sessionId, String ip);

}