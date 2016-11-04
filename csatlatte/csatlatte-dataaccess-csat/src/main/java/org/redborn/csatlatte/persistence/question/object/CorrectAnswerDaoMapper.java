package org.redborn.csatlatte.persistence.question.object;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CorrectAnswerVo;
import org.springframework.stereotype.Repository;

@Repository
public class CorrectAnswerDaoMapper extends SqlSessionDaoSupport implements
		CorrectAnswerDao {

	public List<CorrectAnswerVo> selectList(CorrectAnswerVo correctAnswerVo) {
		return getSqlSession().selectList("question.object.correctanswer.selectList", correctAnswerVo);
	}

}
