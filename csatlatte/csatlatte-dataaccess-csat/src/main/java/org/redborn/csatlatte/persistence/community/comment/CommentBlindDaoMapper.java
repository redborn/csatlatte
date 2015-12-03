package org.redborn.csatlatte.persistence.community.comment;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CommentBlindDaoMapper extends SqlSessionDaoSupport implements CommentBlindDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		
		return getSqlSession().selectOne("community.comment.blind.selectOne", params);
	}

	public int insert(int communityTypeSequence, int communitySequence, int commentSequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		params.put("content", content);
		
		return getSqlSession().insert("community.comment.blind.insert", params);
	}

}
