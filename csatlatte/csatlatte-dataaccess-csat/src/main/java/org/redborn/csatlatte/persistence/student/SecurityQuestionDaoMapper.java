package org.redborn.csatlatte.persistence.student;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityQuestionDaoMapper extends SqlSessionDaoSupport implements SecurityQuestionDao {

	@SuppressWarnings("unchecked")
	public String selectOne(int studentSequence) {
		return (String) ((Map<String, Object>) getSqlSession().selectOne("student.securityQuestion.selectOne", studentSequence)).get("content");
	}
	
	public int insert(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		return getSqlSession().insert("student.securityQuestion.insert", studentSecurityQuestionVo);
	}
	
	public int updateContent(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		return getSqlSession().update("student.securityQuestion.updateContent", studentSecurityQuestionVo);
	}

}
