package org.redborn.csatlatte.persistence.faq;

import java.util.List;

import org.redborn.csatlatte.domain.TypeVo;

public interface TypeDao {
	
	public List<TypeVo> selectList();

}
