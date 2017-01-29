package org.redborn.csatlatte.persistence.question.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CorrectAnswerVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class CorrectAnswerDaoMapper extends SqlSessionDaoSupport implements
		CorrectAnswerDao {
	
	public CorrectAnswerVo selectOne(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		return getSqlSession().selectOne("question.object.correctanswer.selectOne", params);
	}
	
	public List<CorrectAnswerVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().selectList("question.object.correctanswer.selectList", params);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.object.correctanswer.delete", params);
	}
	
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectList", subjectList);
		return getSqlSession().delete("question.object.correctanswer.deleteForModifyRatingCutBySubject", params);
	}
	
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sectionList", sectionList);
		return getSqlSession().delete("question.object.correctanswer.deleteForModifyRatingCutBySection", params);
	}

}
