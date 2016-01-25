package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface AverageDao {

	public List<AverageVo> selectList(int csatSequence, int examSequence);
	public int insert(SubjectVo subjectVo, int average, int standardDeviation);
	
}
