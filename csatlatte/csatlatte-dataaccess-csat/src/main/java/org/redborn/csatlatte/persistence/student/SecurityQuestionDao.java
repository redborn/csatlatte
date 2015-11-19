package org.redborn.csatlatte.persistence.student;

import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;

public interface SecurityQuestionDao {

	public String selectOne(int studentSequence);
	public int insert(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public int updateContent(StudentSecurityQuestionVo studentSecurityQuestionVo);
	
}
