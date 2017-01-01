package org.redborn.csatlatte.persistence.question;

import java.util.List;

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

}
