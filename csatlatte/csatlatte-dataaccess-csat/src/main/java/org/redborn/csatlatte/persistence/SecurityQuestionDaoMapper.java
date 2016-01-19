package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SecurityQuestionVo;

public class SecurityQuestionDaoMapper extends SqlSessionDaoSupport implements SecurityQuestionDao {

	public String selectOne(int studentSequence) {
		return getSqlSession().selectOne("securityQuestion.selectOne", studentSequence);
	}
	
	public List<SecurityQuestionVo> selectList() {
		return getSqlSession().selectList("securityQuestion.selectList");
	}

}
