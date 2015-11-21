package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QnaContentVo;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoMapper extends SqlSessionDaoSupport implements ContentDao {

	public List<String> selectList(int qnaSequence) {
		return getSqlSession().selectOne("qna.content.selectList", qnaSequence);
	}

	public int insert(QnaContentVo qnaContentVo) {
		return getSqlSession().insert("qna.content.insert", qnaContentVo);
	}

}
