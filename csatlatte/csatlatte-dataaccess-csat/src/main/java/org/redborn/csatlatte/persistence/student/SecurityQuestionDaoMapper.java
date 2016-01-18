package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityQuestionDaoMapper extends SqlSessionDaoSupport implements SecurityQuestionDao {

	public String selectOne(int studentSequence) {
		return getSqlSession().selectOne("student.securityQuestion.selectOne", studentSequence);
	}
	
	public List<SecurityQuestionVo> selectList() {
		return getSqlSession().selectList("student.securityQuestion.selectList");
	}
	
	public int insert(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		return getSqlSession().insert("student.securityQuestion.insert", studentSecurityQuestionVo);
	}
	
	public int updateContent(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		return getSqlSession().update("student.securityQuestion.updateContent", studentSecurityQuestionVo);
	}

}
