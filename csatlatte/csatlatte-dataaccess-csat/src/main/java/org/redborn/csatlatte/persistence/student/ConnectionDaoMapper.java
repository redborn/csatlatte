package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.StudentConnectionVo;
import org.springframework.stereotype.Repository;

@Repository
public class ConnectionDaoMapper extends SqlSessionDaoSupport implements ConnectionDao {

	public List<StudentConnectionVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("student.connection.selectListCountYmd", ymd);
	}

	public List<StudentConnectionVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("student.connection.selectListCountYm", ym);
	}

	public List<StudentConnectionVo> selectListCountYear(String year) {
		return getSqlSession().selectList("student.connection.selectListCountYear", year);
	}

}
