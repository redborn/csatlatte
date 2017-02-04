package org.redborn.csatlatte.persistence.question.text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoMapper extends SqlSessionDaoSupport implements ContentDao {

	public List<String> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("textSequence", textSequence);
		return getSqlSession().selectList("question.text.content.selectList", params);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.text.content.delete", params);
	}
	
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectList", subjectList);
		return getSqlSession().delete("question.text.deleteForModifyRatingCutBySubject", params);
	}

}
