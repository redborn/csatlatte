package org.redborn.csatlatte.persistence.connection;

import java.util.List;

import org.redborn.csatlatte.domain.CountVo;

public interface StudentDao {
	
	public List<CountVo> selectListCountYmd(String ymd);
	public List<CountVo> selectListCountYm(String ym);
	public List<CountVo> selectListCountYear(String year);
	
}
