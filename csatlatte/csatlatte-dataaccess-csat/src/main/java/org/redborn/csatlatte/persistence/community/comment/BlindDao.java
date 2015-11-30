package org.redborn.csatlatte.persistence.community.comment;

public interface BlindDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence);
	public int insert(int communityTypeSequence, int communitySequence, int commentSequence, String content);
	
}
