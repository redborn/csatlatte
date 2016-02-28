package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.TypeVo;

public interface CommunityService {
	
	public static final int COMMUNITY = 1;

	public int getCount(String search);
	public boolean blind(int communityTypeSequence, int communitySequence, int blindTypeSequence);
	public boolean blindCheck(int communityTypeSequence, int communitySequence);
	public boolean write(CommunityVo communityVo, String userAgent, String sessionId, String ip);
	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence);
	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, int blindTypeSequence);
	public boolean writeComment(CommentVo commentVo, String userAgent, String sessionId, String ip);
	public boolean deleteComment(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence);
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence, int searchStudentSequence);
	public List<CommunityVo> list(int communityTypeSequence, String search, int pageNumber);
	public List<CommunityVo> list(int communityTypeSequence, int studentSequence);
	public List<CommentVo> commentList(int communityTypeSequence, int communitySequence, int studentSequence);
	public List<TypeVo> blindTypeList();
	public List<TypeVo> reportTypeList();
	public boolean report(int studentSequence,int communityTypeSequence, int communitySequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	public boolean reportComment(int studentSequence,int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	public List<CountVo> dailyActive(int communityTypeSequence, String ymd);
	public List<CountVo> monthlyActive(int communityTypeSequence, String ym);
	public List<CountVo> annualActive(int communityTypeSequence, String year);
	public CommunityVo detail(int communityTypeSequence, int communitySequence);
	
}
