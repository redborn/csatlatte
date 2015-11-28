package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SubjectVo;

public class AverageDaoMapper extends SqlSessionDaoSupport implements AverageDao {

	public int insert(SubjectVo subjectVo, int average, int standardDeviation) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", subjectVo.getCsatSequence());
		params.put("examSequence", subjectVo.getExamSequence());
		params.put("sectionSequence", subjectVo.getSectionSequence());
		params.put("subjectSequence", subjectVo.getSubjectSequence());
		params.put("average", average);
		params.put("standardDeviation", standardDeviation);
		
		return getSqlSession().insert("csat.exam.average.insert", params);
	}

}
