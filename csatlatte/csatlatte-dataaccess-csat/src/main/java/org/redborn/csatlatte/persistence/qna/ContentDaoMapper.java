package org.redborn.csatlatte.persistence.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoMapper extends SqlSessionDaoSupport implements ContentDao {

	public List<String> selectList(int qnaSequence) {
		return getSqlSession().selectOne("qna.content.selectList", qnaSequence);
	}

	public int insert(int qnaSequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		return getSqlSession().insert("qna.content.insert", params);
	}

}
