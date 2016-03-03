package org.redborn.csatlatte.persistence.community.comment;

public interface CommentBlindDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence);
	public int insert(int communityTypeSequence, int communitySequence, int commentSequence, int blindTypeSequence);
	
}
