package org.redborn.csatlatte.persistence.question.object;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoMapper extends SqlSessionDaoSupport implements ImageDao {

	public int selectOneCount(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence,
			int objectItemSequence, int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		params.put("objectItemSequence", objectItemSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.object.image.selectOneCount", params);
	}

	public String selectOneFileName(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence,
			int objectItemSequence, int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		params.put("objectItemSequence", objectItemSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.object.image.selectOneFileName", params);
	}

	public String selectOneFileCode(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence, int questionSequence,
			int objectItemSequence, int imageSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		params.put("objectItemSequence", objectItemSequence);
		params.put("imageSequence", imageSequence);
		return getSqlSession().selectOne("question.object.image.selectOneFileCode", params);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.object.image.delete", params);
	}

}
