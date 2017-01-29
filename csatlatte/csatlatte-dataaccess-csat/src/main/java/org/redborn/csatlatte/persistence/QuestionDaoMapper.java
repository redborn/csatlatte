package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
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
	
	public QuestionVo selectOneForRandomsolving(List<Integer> yearStudentSequence,
			List<Integer> subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("yearStudentSequenceList", yearStudentSequence);
		params.put("subjectSequenceList", subjectSequence);
		return getSqlSession().selectOne("question.selectOneForRandomsolving", params);
	}
	
	public int selectOneCount(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		logger.info("test1 : " + csatSequence);
		params.put("examSequence", examSequence);
		logger.info("test2 : " + examSequence);
		params.put("sectionSequence", sectionSequence);
		logger.info("test3 : " + sectionSequence);
		params.put("subjectSequence", subjectSequence);
		logger.info("test4 : " + subjectSequence);
		return getSqlSession().selectOne("question.selectOneCount", params);
	}

	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.delete", params);
	}
	
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectList", subjectList);
		return getSqlSession().delete("question.deleteForModifyRatingCutBySubject", params);
	}
	
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sectionList", sectionList);
		return getSqlSession().delete("question.deleteForModifyRatingCutBySection", params);
	}

}