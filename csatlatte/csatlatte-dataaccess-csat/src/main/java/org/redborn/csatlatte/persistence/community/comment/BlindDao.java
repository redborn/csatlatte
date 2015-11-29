package org.redborn.csatlatte.persistence.community.comment;

public interface BlindDao {

	public int selectOne(int communitySequence, int commentSequence);
	public int insert(int communitySequence, int commentSequence, String content);
	
}
