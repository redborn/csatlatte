package org.redborn.csatlatte.persistence.community;

public interface ReportDao {

	public int selectOne(int communitySequence, int studentSequence);
	public int insert(int communitySequence, int studentSequence, int reportTypeSequence);
	
}
