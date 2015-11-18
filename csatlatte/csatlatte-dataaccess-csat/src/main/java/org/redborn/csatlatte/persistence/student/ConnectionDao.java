package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.redborn.csatlatte.domain.StudentConnectionVo;

public interface ConnectionDao {
	
	public List<StudentConnectionVo> selectListCountYmd(String ymd);
	public List<StudentConnectionVo> selectListCountYm(String ym);
	public List<StudentConnectionVo> selectListCountYear(String year);
	
}
