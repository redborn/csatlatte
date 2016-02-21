package org.redborn.csatlatte.persistence.community.comment;

public interface CommentReportDao {
	
	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	public int insert(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	
}
