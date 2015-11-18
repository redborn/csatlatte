package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.redborn.csatlatte.domain.StudentScqsVo;

public interface ScqsDao {

	public int updateContent(StudentScqsVo studentScqsVo);
	public int insert(StudentScqsVo studentScqsVo);
	public String selectOne(int studentSequence);
	
	
}
