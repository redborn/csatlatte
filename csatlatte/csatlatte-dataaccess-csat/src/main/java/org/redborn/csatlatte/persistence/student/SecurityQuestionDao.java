package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;

public interface SecurityQuestionDao {

	public String selectOne(int studentSequence);
	public List<SecurityQuestionVo> selectList();
	public int insert(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public int updateContent(StudentSecurityQuestionVo studentSecurityQuestionVo);
	
}
