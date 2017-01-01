package org.redborn.csatlatte.persistence.question.text;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
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

}
