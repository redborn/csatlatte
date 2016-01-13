package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.InstitutionVo;

public interface InstitutionDao {

	public List<InstitutionVo> selectList();
	
}
