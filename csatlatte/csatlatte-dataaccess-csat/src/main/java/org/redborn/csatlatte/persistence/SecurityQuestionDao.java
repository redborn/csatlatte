package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.SecurityQuestionVo;

public interface SecurityQuestionDao {
	
	public String selectOne(int studentSequence);
	public List<SecurityQuestionVo> selectList();

}
