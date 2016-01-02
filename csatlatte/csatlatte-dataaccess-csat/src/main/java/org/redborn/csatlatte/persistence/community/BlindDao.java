package org.redborn.csatlatte.persistence.community;

public interface BlindDao {
	
	public int selectOne(int communityTypeSequence, int communitySequence);
	public int insert(int communityTypeSequence, int communitySequence, int blindTypeSequence);
	
}
