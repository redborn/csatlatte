package org.redborn.csatlatte.persistence.student;

import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;

public interface SecurityQuestionDao {

	public int updateContent(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public int insert(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public String selectOne(int studentSequence);
	
	
}
