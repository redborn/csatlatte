package org.redborn.csatlatte.service;

import java.util.ArrayList;
import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
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

	public List<YmdCountVo> dailyActive(int communityTypeSequence, String ymd) {
		List<YmdCountVo> communityActive = communityDao.selectListCountYmd(communityTypeSequence, ymd);
		List<YmdCountVo> commentActive = commentDao.selectListCountYmd(communityTypeSequence, ymd);
		List<YmdCountVo> resultActive = new ArrayList<YmdCountVo>();
		
		int communityActiveIndex = 0;
		int commentActiveIndex = 0;
		int communityActiveIndexMax = communityActive.size();
		int commentActiveIndexMax = commentActive.size();
		
		for (int index = 0; index <= 23; index++) {
			YmdCountVo ymdCountVo = new YmdCountVo();
			
			int sumCount = 0;
			
			if (communityActiveIndex < communityActiveIndexMax && communityActive.get(communityActiveIndex).getHour() == index) {
				sumCount += communityActive.get(index).getCount();
				communityActiveIndex++;
			}
			
			if (commentActiveIndex < commentActiveIndexMax && commentActive.get(commentActiveIndex).getHour() == index) {
				sumCount += commentActive.get(index).getCount();
				commentActiveIndex++;
			}
			
			ymdCountVo.setHour(index);
			ymdCountVo.setCount(sumCount);
			
			resultActive.add(ymdCountVo);
		}
		
		return resultActive;
	}

	public List<YmCountVo> monthlyActive(int communityTypeSequence, String ym) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<YearCountVo> annualActive(int communityTypeSequence, String year) {
		// TODO Auto-generated method stub
		return null;
	}

}
