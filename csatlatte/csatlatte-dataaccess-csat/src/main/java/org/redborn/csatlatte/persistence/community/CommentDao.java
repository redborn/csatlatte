package org.redborn.csatlatte.persistence.community;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface CommentDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	public List<YmdCountVo> selectListCountYmd(String ymd);
	public List<YmCountVo> selectListCountYm(String ym);
	public List<YearCountVo> selectListCountYear(String year);
	public List<CommentVo> selectList(int communityTypeSequence, int communitySequence);
	public int insert(CommentVo commentVo);
	public int update(CommentVo commentVo);
	public int updateUseYnN(int communitySequence, int commentSequence);
	
}
