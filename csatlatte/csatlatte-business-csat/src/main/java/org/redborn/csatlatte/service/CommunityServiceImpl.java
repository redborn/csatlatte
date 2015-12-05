package org.redborn.csatlatte.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.persistence.CommunityDao;
import org.redborn.csatlatte.persistence.community.BlindDao;
import org.redborn.csatlatte.persistence.community.CommentDao;
import org.redborn.csatlatte.persistence.community.ReportDao;
import org.redborn.csatlatte.persistence.community.comment.CommentBlindDao;
import org.redborn.csatlatte.persistence.community.comment.CommentReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDao communityDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private BlindDao blindDao;
	@Autowired
	private CommentBlindDao commentBlindDao;
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private CommentReportDao commentReportDao;
	
	public boolean blind(int communityTypeSequence, int communitySequence, String content) {
		return blindDao.selectOne(communityTypeSequence, communitySequence) == 0 
				&& blindDao.insert(communityTypeSequence, communitySequence, content) == 1;
	}

	public boolean write(CommunityVo communityVo) {
		return communityDao.insert(communityVo) == 1;
	}

	public boolean modify(CommunityVo communityVo) {
		return communityDao.selectOne(communityVo.getCommunityTypeSequence(), communityVo.getCommunitySequence(), communityVo.getStudentSequence()) == 1 
				&& communityDao.update(communityVo) == 1;
	}

	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence) {
		return communityDao.selectOne(communityTypeSequence, communitySequence, studentSequence) == 1 
				&& communityDao.updateUseYnN(communityTypeSequence, communitySequence) == 1;
	}

	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, String content) {
		return commentBlindDao.selectOne(communityTypeSequence, communitySequence, commentSequence) == 0 
				&& commentBlindDao.insert(communityTypeSequence, communitySequence, commentSequence, content) == 1;
	}

	public boolean writeComment(CommentVo commentVo) {
		return commentDao.insert(commentVo) == 1;
	}

	public boolean modifyComment(CommentVo commentVo) {
		return commentDao.selectOne(commentVo.getCommunityTypeSequence(), commentVo.getCommunitySequence(), commentVo.getCommentSequence(), commentVo.getStudentSequence()) == 1
				&& commentDao.update(commentVo) == 1;
	}

	public boolean deleteComment(CommentVo commentVo) {
		return commentDao.selectOne(commentVo.getCommunityTypeSequence(), commentVo.getCommunitySequence(), commentVo.getCommentSequence(), commentVo.getStudentSequence()) == 1 
				&& commentDao.updateUseYnN(commentVo.getCommunityTypeSequence(), commentVo.getCommunitySequence(), commentVo.getCommentSequence()) == 1;
	}

	public List<CommunityVo> list(int communityTypeSequence) {
		return communityDao.selectList(communityTypeSequence);
	}
	
	public List<CommunityVo> list(int communityTypeSequence, String search, int pageNumber) {
		return communityDao.selectListForManage(communityTypeSequence, search, pageNumber);
	}

	public List<CommunityVo> list(int communityTypeSequence, int studentSequence) {
		return communityDao.selectListStudentText(communityTypeSequence, studentSequence);
	}

	public List<CommentVo> commentList(int communityTypeSequence, int communitySequence) {
		return commentDao.selectList(communityTypeSequence, communitySequence);
	}

	public boolean report(int studentSequence, int communityTypeSequence, int communitySequence, int reportTypeSequence) {
		return reportDao.selectOne(communitySequence, studentSequence) == 0
				&& reportDao.insert(communityTypeSequence, communitySequence, studentSequence, reportTypeSequence) == 1;
	}

	public boolean reportComment(int studentSequence, int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence) {
		return commentReportDao.selectOne(communityTypeSequence, communitySequence, commentSequence, studentSequence) == 0
				&& commentReportDao.insert(communityTypeSequence, communitySequence, commentSequence, studentSequence, reportTypeSequence) == 1;
	}
	
	private List<CountVo> margeCountVoList(List<CountVo> communityYmdCountVos, List<CountVo> commentYmdCountVos, int begin, int end) {
		List<CountVo> ymdCountVos = new ArrayList<CountVo>();
		
		int communityYmdCountVosIndex = 0;
		int commentYmdCountVosIndex = 0;
		int communityYmdCountVosSize = communityYmdCountVos != null ? communityYmdCountVos.size() : 0;
		int commentYmdCountVosSize = commentYmdCountVos != null ? commentYmdCountVos.size() : 0;
		
		for (int index = begin; index <= end; index++) {
			CountVo ymdCountVo = new CountVo();
			
			int sumCount = 0;
			
			if (communityYmdCountVosIndex < communityYmdCountVosSize) {
				CountVo communityCountVo = communityYmdCountVos.get(communityYmdCountVosIndex);
				if (communityCountVo.getKey() == index) {
					sumCount = communityCountVo.getCount();
					communityYmdCountVosIndex++;
				}
			}
			
			if (commentYmdCountVosIndex < commentYmdCountVosSize) {
				CountVo commentCountVo = commentYmdCountVos.get(commentYmdCountVosIndex);
				if (commentCountVo.getKey() == index) {
					sumCount += commentCountVo.getCount();
					commentYmdCountVosIndex++;
				}
			}
			
			ymdCountVo.setKey(index);
			ymdCountVo.setCount(sumCount);
			
			ymdCountVos.add(ymdCountVo);
		}
		
		return ymdCountVos;
	}

	public List<CountVo> dailyActive(int communityTypeSequence, String ymd) {
		return margeCountVoList(communityDao.selectListCountYmd(communityTypeSequence, ymd), commentDao.selectListCountYmd(communityTypeSequence, ymd), 0, 23);
	}

	public List<CountVo> monthlyActive(int communityTypeSequence, String ym) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(5, 6)) - 1, 1);
		return margeCountVoList(communityDao.selectListCountYm(communityTypeSequence, ym), commentDao.selectListCountYm(communityTypeSequence, ym), 1, calendar.getActualMaximum(Calendar.DATE));
	}

	public List<CountVo> annualActive(int communityTypeSequence, String year) {
		return margeCountVoList(communityDao.selectListCountYear(communityTypeSequence, year), commentDao.selectListCountYear(communityTypeSequence, year), 1, 12);
	}

}
