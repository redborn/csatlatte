package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
import org.springframework.stereotype.Repository;

@Repository
public class ConnectionDaoMapper extends SqlSessionDaoSupport implements ConnectionDao {

	public List<YmdCountVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("student.connection.selectListCountYmd", ymd);
	}

	public List<YmCountVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("student.connection.selectListCountYm", ym);
	}

	public List<YearCountVo> selectListCountYear(String year) {
		return getSqlSession().selectList("student.connection.selectListCountYear", year);
	}

}
