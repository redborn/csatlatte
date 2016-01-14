package org.redborn.csatlatte.persistence.connection;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoMapper extends SqlSessionDaoSupport implements StudentDao {

	public List<YmdCountVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("connection.student.selectListCountYmd", ymd);
	}

	public List<YmCountVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("connection.student.selectListCountYm", ym);
	}

	public List<YearCountVo> selectListCountYear(String year) {
		return getSqlSession().selectList("connection.student.selectListCountYear", year);
	}

}
