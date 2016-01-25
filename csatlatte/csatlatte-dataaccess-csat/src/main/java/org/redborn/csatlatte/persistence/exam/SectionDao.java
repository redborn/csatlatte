package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.SectionVo;

public interface SectionDao {
	
	public List<SectionVo> selectList(int csatSequence, int examSequence);
	
}
