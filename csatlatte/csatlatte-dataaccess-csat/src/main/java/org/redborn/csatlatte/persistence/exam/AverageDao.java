package org.redborn.csatlatte.persistence.exam;

import org.redborn.csatlatte.domain.SubjectVo;

public interface AverageDao {

	public int insert(SubjectVo subjectVo, int average, int standardDeviation);
	
}
