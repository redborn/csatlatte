package org.redborn.csatlatte.persistence.qna;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDaoMapper extends SqlSessionDaoSupport implements AnswerDao {

	public int insert(QnaAnswerVo qnaAnswerVo) {
		return getSqlSession().insert("qna.answer.insert", qnaAnswerVo);
	}

}
