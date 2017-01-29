package org.redborn.csatlatte.persistence.question.text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoMapper extends SqlSessionDaoSupport implements ImageDao {
	
	public int selectOneCount(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int textSequence,
			int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("textSequence", textSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.text.image.selectOneCount", params);
	}

	public String selectOneFileName(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int textSequence,
			int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("textSequence", textSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.text.image.selectOneFileName", params);
	}

	public String selectOneFileCode(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int textSequence,
			int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("textSequence", textSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.text.image.selectOneFileCode", params);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.text.image.delete", params);
	}
	
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectList", subjectList);
		return getSqlSession().delete("question.text.image.deleteForModifyRatingCutBySubject", params);
	}
	
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sectionList", sectionList);
		return getSqlSession().delete("question.text.image.deleteForModifyRatingCutBySection", params);
	}

}
