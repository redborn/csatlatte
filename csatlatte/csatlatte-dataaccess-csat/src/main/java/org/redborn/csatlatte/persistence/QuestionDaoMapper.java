package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QuestionVo;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoMapper extends SqlSessionDaoSupport implements QuestionDao {

	public QuestionVo selectOne(int csatSequence, int examSequence, 
			int sectionSequence, int subjectSequence, int questionSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		return getSqlSession().selectOne("question.selectOne", params);
	}
	
	public List<QuestionVo> selectList(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().selectList("question.selectList", params);
	}
	
	public List<QuestionVo> selectListForRandomsolving(List<Integer> yearStudentSequenceList,
			List<Integer> subjectSequenceList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("yearStudentSequenceList", yearStudentSequenceList);
		params.put("subjectSequenceList", subjectSequenceList);
		return getSqlSession().selectList("question.selectListForRandomsolving", params);
	}

}