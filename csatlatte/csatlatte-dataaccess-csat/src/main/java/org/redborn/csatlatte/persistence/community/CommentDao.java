package org.redborn.csatlatte.persistence.community;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface CommentDao {

	public int selectOne(int commentSequence, int studentSequence);
	public List<YmdCountVo> selectOneCountYmd(String ymd);
	public List<YmCountVo> selectOneCountYm(String ym);
	public List<YearCountVo> selectOneCountYear(String year);
	public List<CommentVo> selectList();
	public int insert(int communitySequence, int studentSequence, String content);
	public int update(String content, int communitySequence, int commentSequence);
	public int updateUseYnN(int communitySequence, int commentSequence);
	
}
