package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.StudentConnectionYearVo;
import org.redborn.csatlatte.domain.StudentConnectionYmVo;
import org.redborn.csatlatte.domain.StudentConnectionYmdVo;
import org.springframework.stereotype.Repository;

@Repository
public class ConnectionDaoMapper extends SqlSessionDaoSupport implements ConnectionDao {

	public List<StudentConnectionYmdVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("student.connection.selectListCountYmd", ymd);
	}

	public List<StudentConnectionYmVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("student.connection.selectListCountYm", ym);
	}

	public List<StudentConnectionYearVo> selectListCountYear(String year) {
		return getSqlSession().selectList("student.connection.selectListCountYear", year);
	}

}
