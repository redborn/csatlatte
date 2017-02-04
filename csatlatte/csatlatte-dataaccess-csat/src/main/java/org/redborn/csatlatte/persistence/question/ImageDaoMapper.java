package org.redborn.csatlatte.persistence.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoMapper extends SqlSessionDaoSupport implements ImageDao {

	public int selectOneCount(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence,
			int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.image.selectOneCount", params);
	}

	public String selectOneFileName(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence,
			int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.image.selectOneFileName", params);
	}

	public String selectOneFileCode(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence,
			int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.image.selectOneFileCode", params);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.image.delete", params);
	}
	
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectList", subjectList);
		return getSqlSession().delete("question.image.deleteForModifyRatingCutBySubject", params);
	}

}
