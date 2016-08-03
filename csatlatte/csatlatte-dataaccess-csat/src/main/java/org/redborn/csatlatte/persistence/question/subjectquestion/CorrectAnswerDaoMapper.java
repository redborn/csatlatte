package org.redborn.csatlatte.persistence.question.subjectquestion;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CorrectAnswerDaoMapper extends SqlSessionDaoSupport implements CorrectAnswerDao {

	public int delete(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("question.subjectquestion.correctanswer.delete", params);
	}

}
