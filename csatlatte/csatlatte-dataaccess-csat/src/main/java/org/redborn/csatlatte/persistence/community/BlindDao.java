package org.redborn.csatlatte.persistence.community;

public interface BlindDao {
	
	public int selectOne(int communitySequence);
	public int insert(int communitySequence, String content);
	
}
