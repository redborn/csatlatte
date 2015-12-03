package org.redborn.csatlatte.persistence.community;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CountVo;

public interface CommentDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	public List<CountVo> selectListCountYmd(int communityTypeSequence, String ymd);
	public List<CountVo> selectListCountYm(int communityTypeSequence, String ym);
	public List<CountVo> selectListCountYear(int communityTypeSequence, String year);
	public List<CommentVo> selectList(int communityTypeSequence, int communitySequence);
	public int insert(CommentVo commentVo);
	public int update(CommentVo commentVo);
	public int updateUseYnN(int communityTypeSequence, int communitySequence, int commentSequence);
	
}
