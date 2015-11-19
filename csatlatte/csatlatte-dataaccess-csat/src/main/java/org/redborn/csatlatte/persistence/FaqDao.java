package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.FaqVo;

public interface FaqDao {

	public List<FaqVo> selectList(int faqTypeSequence);
	
}
