package org.redborn.csatlatte.persistence.connection;

public interface UriDao {
	
	public int insert(String uri, String userAgent, String sessionId, String ip); 

}