package org.redborn.csatlatte.persistence.community;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BlindDaoMapper extends SqlSessionDaoSupport implements BlindDao {

	public int selectOne(int communitySequence) {
		return getSqlSession().selectOne("community.blind.selectOne", communitySequence);
	}

	public int insert(int communitySequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("content", content);
		
		return getSqlSession().insert("community.blind.insert", params);
	}

}
