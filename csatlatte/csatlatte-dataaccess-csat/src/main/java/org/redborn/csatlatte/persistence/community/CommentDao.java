package org.redborn.csatlatte.persistence.community;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CountVo;

public interface CommentDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	public List<CountVo> selectListCountYmd(int communityTypeSequence, String ymd);
	public List<CountVo> selectListCountYm(int communityTypeSequence, String ym);
	public List<CountVo> selectListCountYear(int communityTypeSequence, String year);
	public List<CommentVo> selectList(int communityTypeSequence, int communitySequence, int studentSequence);
	public int insert(CommentVo commentVo, String userAgent, String sessionId, String ip);
	public int updateUseYnN(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	
}
