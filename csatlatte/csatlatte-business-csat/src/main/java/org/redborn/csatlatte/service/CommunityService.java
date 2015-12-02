package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface CommunityService {

	public boolean blind(int communityTypeSequence, int communitySequence, String content);
	public boolean write(CommunityVo communityVo);
	public boolean modify(CommunityVo communityVo);
	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence);
	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, String content);
	public boolean writeComment(CommentVo commentVo);
	public boolean modifyComment(CommentVo commentVo);
	public boolean deleteComment(CommentVo commentVo);
	public List<CommunityVo> list(int communityTypeSequence);
	public List<CommunityVo> list(int communityTypeSequence, int studentSequence);
	public List<CommentVo> commentList(int communityTypeSequence, int communitySequence);
	public boolean report(int studentSequence,int communityTypeSequence, int communitySequence, int reportTypeSequence);
	public boolean reportComment(int studentSequence,int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence);
	public List<YmdCountVo> dailyActive(int communityTypeSequence, String ymd);
	public List<YmCountVo> monthlyActive(int communityTypeSequence, String ym);
	public List<YearCountVo> annualActive(int communityTypeSequence, String year);
	
}
