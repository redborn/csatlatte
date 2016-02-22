package org.redborn.csatlatte.persistence.connection;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UriDaoMapper extends SqlSessionDaoSupport implements UriDao {

	public int insert(String uri, String userAgent, String sessionId, String ip) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uri", uri);
		params.put("userAgent", userAgent);
		params.put("sessionId", sessionId);
		params.put("ip", ip);
		return getSqlSession().insert("connection.uri.insert", params);
	}

}
