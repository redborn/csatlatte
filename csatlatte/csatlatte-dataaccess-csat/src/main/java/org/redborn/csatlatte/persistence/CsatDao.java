package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.CsatVo;

public interface CsatDao {

	public CsatVo selectOne(int csatSequence);
	public List<CsatVo> selectListYear();
	
}