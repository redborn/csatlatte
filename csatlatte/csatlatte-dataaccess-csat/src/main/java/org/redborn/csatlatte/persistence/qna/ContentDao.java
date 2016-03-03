package org.redborn.csatlatte.persistence.qna;

import java.util.List;

public interface ContentDao {
	
	public List<String> selectList(int qnaSequence);
	public int insert(int qnaSequence, String content);
	
}
