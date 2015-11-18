package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.redborn.csatlatte.domain.StudentScqsVo;

public interface ScqsDao {

	public int updateContent(int studentSequence, int scqsSequence, String content);
	public int insert(int studentSequence, int scqsSequence, String content);
	public String selectOne(int studentSequence);
	
	
}
