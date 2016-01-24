package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.YearStudentVo;
import org.springframework.stereotype.Repository;

@Repository
public class YearStudentDaoMapper extends SqlSessionDaoSupport implements YearStudentDao {

	public List<YearStudentVo> selectList() {
		return getSqlSession().selectList("yearStudent.selectList");
	}

}
