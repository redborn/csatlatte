package org.redborn.csatlatte.persistence.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ObjectiveItemVo;
import org.redborn.csatlatte.domain.QuestionVo;
import org.springframework.stereotype.Repository;

@Repository
public class ObjectiveItemDaoMapper extends SqlSessionDaoSupport implements
		ObjectiveItemDao {

	public List<ObjectiveItemVo> selectList(QuestionVo questionVo) {
		return getSqlSession().selectList("question.objectiveitem.selectList", questionVo);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("question.objectiveitem.delete", params);
	}

}
