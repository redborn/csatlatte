package org.redborn.csatlatte.persistence.community.comment;

public interface ReportDao {
	
	public int selectOne(int communitySequence, int commentSequence, int studentSequence);
	public int insert(int communitySequence, int commentSequence, int studentSequence, int reportTypeSequence);
	
}
