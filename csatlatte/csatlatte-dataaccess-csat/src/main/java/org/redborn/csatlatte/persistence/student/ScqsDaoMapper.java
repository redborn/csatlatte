package org.redborn.csatlatte.persistence.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.StudentScqsVo;
import org.springframework.stereotype.Repository;

@Repository
public class ScqsDaoMapper extends SqlSessionDaoSupport implements ScqsDao {

	public int updateContent(int studentSequence, int scqsSequence, String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentSequence", studentSequence);
		map.put("scqsSequence", scqsSequence);
		map.put("content", content);
		
		return getSqlSession().update("student.scqs.updateContent", map);
	}

	public int insert(int studentSequence, int scqsSequence, String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentSequence", studentSequence);
		map.put("scqsSequence", scqsSequence);
		map.put("content", content);
		
		return getSqlSession().insert("student.scqs.insert", map);
	}

	public String selectOne(int studentSequence) {
		return getSqlSession().selectOne("student.scqs.selectOne", studentSequence);
	}

}
