package org.redborn.csatlatte.persistence.connection;

import java.util.List;

import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface StudentDao {
	
	public List<YmdCountVo> selectListCountYmd(String ymd);
	public List<YmCountVo> selectListCountYm(String ym);
	public List<YearCountVo> selectListCountYear(String year);
	
}
