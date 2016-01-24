package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.YearStudentVo;

public interface YearStudentDao {

	public List<YearStudentVo> selectList();
	
}
