package org.redborn.csatlatte.service;

import org.redborn.csatlatte.persistence.connection.UriDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UriServiceImpl implements UriService {
	
	@Autowired
	private UriDao uriDao;

	public boolean connection(String uri, String userAgent, String sessionId,
			String ip) {
		return uriDao.insert(uri, userAgent, sessionId, ip) == 1;
	}

}
