package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDaoMapper extends SqlSessionDaoSupport implements AnswerDao {

	public int insert(QnaAnswerVo qnaAnswerVo) {
		return getSqlSession().insert("qna.answer.insert", qnaAnswerVo);
	}
	
	public List<String> selectList(int qnaSequence) {
		return getSqlSession().selectList("qna.answer.selectList", qnaSequence);
	}

}
