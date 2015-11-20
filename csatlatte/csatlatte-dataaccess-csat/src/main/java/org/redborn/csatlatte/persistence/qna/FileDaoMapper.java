package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QnaFileVo;
import org.springframework.stereotype.Repository;

@Repository
public class FileDaoMapper extends SqlSessionDaoSupport implements FileDao {

	public List<QnaFileVo> selectList(int qnaSequence) {
		return getSqlSession().selectList("qna.file.selectList", qnaSequence);
	}

	public int insert(QnaFileVo qnaFileVo) {
		return getSqlSession().insert("qna.file.selectList", qnaFileVo);
	}

}
