package org.redborn.csatlatte.service;

import org.redborn.csatlatte.persistence.connection.UriDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UriServiceImpl implements UriService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UriDao uriDao;

	public boolean connection(String uri, String userAgent, String sessionId,
			String ip) {
		logger.info("Business layer uri connection.");
		boolean result = false;
		if (!"ELB-HealthChecker/1.0".equals(userAgent)) {
			result = uriDao.insert(uri, userAgent, sessionId, ip) == 1;
		}
		return result;
	}

}
