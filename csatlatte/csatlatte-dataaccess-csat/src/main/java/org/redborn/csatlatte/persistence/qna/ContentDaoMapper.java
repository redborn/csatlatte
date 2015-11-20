package org.redborn.csatlatte.persistence.qna;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QnaContentVo;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoMapper extends SqlSessionDaoSupport implements ContentDao {

	public String selectOne(int qnaSequence) {
		return getSqlSession().selectOne("qna.content.selectOne", qnaSequence);
	}

	public int insert(QnaContentVo qnaContentVo) {
		return getSqlSession().insert("qna.content.insert", qnaContentVo);
	}

}
