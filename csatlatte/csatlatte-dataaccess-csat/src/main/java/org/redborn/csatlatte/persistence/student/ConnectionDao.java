package org.redborn.csatlatte.persistence.student;

import java.util.List;

import org.redborn.csatlatte.domain.StudentConnectionYearVo;
import org.redborn.csatlatte.domain.StudentConnectionYmVo;
import org.redborn.csatlatte.domain.StudentConnectionYmdVo;

public interface ConnectionDao {
	
	public List<StudentConnectionYmdVo> selectListCountYmd(String ymd);
	public List<StudentConnectionYmVo> selectListCountYm(String ym);
	public List<StudentConnectionYearVo> selectListCountYear(String year);
	
}
