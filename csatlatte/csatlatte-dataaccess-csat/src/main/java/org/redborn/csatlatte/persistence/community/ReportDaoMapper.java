package org.redborn.csatlatte.persistence.community;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoMapper extends SqlSessionDaoSupport implements ReportDao {

	public int selectOne(int communitySequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.report.selectOne", params);
	}

	public int insert(int communityTypeSequence, int communitySequence, int studentSequence, int reportTypeSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		params.put("reportTypeSequence", reportTypeSequence);
		
		return getSqlSession().insert("community.report.insert", params);
	}

}
