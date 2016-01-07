package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.IstttVo;

public interface IstttDao {

	public List<IstttVo> selectList();
	
}
