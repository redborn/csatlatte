package org.redborn.csatlatte.persistence.community.comment;

public interface ReportDao {
	
	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	public int insert(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence, int reportTypeSequence);
	
}
