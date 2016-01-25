package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.SubjectVo;

public interface SubjectDao {

	public List<SubjectVo> selectList(int csatSequence, int examSequence);
	
}
