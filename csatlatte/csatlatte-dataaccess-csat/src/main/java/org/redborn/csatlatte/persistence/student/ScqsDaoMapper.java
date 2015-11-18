package org.redborn.csatlatte.persistence.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.StudentScqsVo;
import org.springframework.stereotype.Repository;

@Repository
public class ScqsDaoMapper extends SqlSessionDaoSupport implements ScqsDao {

	public int updateContent(StudentScqsVo studentScqsVo) {
		return getSqlSession().update("student.scqs.updateContent", studentScqsVo);
	}

	public int insert(StudentScqsVo studentScqsVo) {
		return getSqlSession().insert("student.scqs.insert", studentScqsVo);
	}

	public String selectOne(int studentSequence) {
		return getSqlSession().selectOne("student.scqs.selectOne", studentSequence);
	}

}
