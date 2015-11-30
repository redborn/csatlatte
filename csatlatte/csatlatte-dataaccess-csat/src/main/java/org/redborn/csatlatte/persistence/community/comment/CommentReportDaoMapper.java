package org.redborn.csatlatte.persistence.community.comment;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CommentReportDaoMapper extends SqlSessionDaoSupport implements CommentReportDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.comment.report.selectOne", params);
	}

	public int insert(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence, int reportTypeSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		params.put("studentSequence", studentSequence);
		params.put("reportTypeSequence", reportTypeSequence);
		
		return getSqlSession().insert("community.comment.report.insert", params);
	}

}
