package org.redborn.csatlatte.persistence.connection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CountVo;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoMapper extends SqlSessionDaoSupport implements StudentDao {

	public List<CountVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("connection.student.selectListCountYmd", ymd);
	}

	public List<CountVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("connection.student.selectListCountYm", ym);
	}

	public List<CountVo> selectListCountYear(String year) {
		return getSqlSession().selectList("connection.student.selectListCountYear", year);
	}

	public int insert(int studentSequence, String userAgent, String sessionId,
			String ip) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("userAgent", userAgent);
		params.put("sessionId", sessionId);
		params.put("ip", ip);
		return getSqlSession().insert("connection.student.insert", params);
	}

}
