package org.redborn.csatlatte.persistence.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.TextVo;
import org.springframework.stereotype.Repository;

@Repository
public class TextDaoMapper extends SqlSessionDaoSupport implements TextDao {

	public TextVo selectOne(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("questionSequence", questionSequence);
		return getSqlSession().selectOne("question.text.selectOne", params);
	}
	
	public List<TextVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().selectList("question.text.selectList", params);
	}
	
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.text.delete", params);
	}
	
}
