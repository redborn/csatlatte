package org.redborn.csatlatte.persistence.question.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CorrectAnswerVo;
import org.springframework.stereotype.Repository;

@Repository
public class CorrectAnswerDaoMapper extends SqlSessionDaoSupport implements
		CorrectAnswerDao {

	public List<CorrectAnswerVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().selectList("question.object.correctanswer.selectList", params);
	}

}
