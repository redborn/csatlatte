package org.redborn.csatlatte.persistence.faq;

import java.util.List;

import org.redborn.csatlatte.domain.FaqTypeVo;

public interface TypeDao {
	
	public List<FaqTypeVo> selectList();

}
