package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.CsatVo;

public interface CsatDao {
	
	public List<CsatVo> selectListYear();
}
