package org.redborn.csatlatte.service;

import java.util.ArrayList;
import java.util.Calendar;
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
			
			if (communityActive != null && communityActiveIndex < communityActiveIndexMax && communityActive.get(communityActiveIndex).getHour() == index) {
				sumCount += communityActive.get(communityActiveIndex).getCount();
				communityActiveIndex++;
			}
			
			if (commentActive != null && commentActiveIndex < commentActiveIndexMax && commentActive.get(commentActiveIndex).getHour() == index) {
				sumCount += commentActive.get(commentActiveIndex).getCount();
				commentActiveIndex++;
			}
			
			ymdCountVo.setHour(index);
			ymdCountVo.setCount(sumCount);
			
			resultActive.add(ymdCountVo);
		}
		
		return resultActive;
	}

	public List<YmCountVo> monthlyActive(int communityTypeSequence, String ym) {
		List<YmCountVo> communityActive = communityDao.selectListCountYm(communityTypeSequence, ym);
		List<YmCountVo> commentActive = commentDao.selectListCountYm(communityTypeSequence, ym);
		List<YmCountVo> resultActive = new ArrayList<YmCountVo>();
		
		int communityActiveIndex = 0;
		int commentActiveIndex = 0;
		int communityActiveIndexMax = communityActive.size();
		int commentActiveIndexMax = commentActive.size();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(5, 6)) - 1, 1);
		
		int monthMaxDay = calendar.getActualMaximum(Calendar.DATE);
		
		for (int index = 1; index <= monthMaxDay; index++) {
			YmCountVo ymCountVo = new YmCountVo();
			
			int sumCount = 0;
			
			if (communityActive != null && communityActiveIndex < communityActiveIndexMax && communityActive.get(communityActiveIndex).getDay() == index) {
				sumCount += communityActive.get(communityActiveIndex).getCount();
				communityActiveIndex++;
			}
			
			if (commentActive != null && commentActiveIndex < commentActiveIndexMax && commentActive.get(commentActiveIndex).getDay() == index) {
				sumCount += commentActive.get(commentActiveIndex).getCount();
				commentActiveIndex++;
			}
			
			ymCountVo.setDay(index);
			ymCountVo.setCount(sumCount);
			
			resultActive.add(ymCountVo);
		}
		
		return resultActive;
	}

	public List<YearCountVo> annualActive(int communityTypeSequence, String year) {
		List<YearCountVo> communityActive = communityDao.selectListCountYear(communityTypeSequence, year);
		List<YearCountVo> commentActive = commentDao.selectListCountYear(communityTypeSequence, year);
		List<YearCountVo> resultActive = new ArrayList<YearCountVo>();
		
		int communityActiveIndex = 0;
		int commentActiveIndex = 0;
		int communityActiveIndexMax = communityActive.size();
		int commentActiveIndexMax = commentActive.size();
		
		for (int index = 1; index <= 12; index++) {
			YearCountVo yearCountVo = new YearCountVo();
			
			int sumCount = 0;
			
			if (communityActive != null && communityActiveIndex < communityActiveIndexMax && communityActive.get(communityActiveIndex).getMonth() == index) {
				sumCount += communityActive.get(communityActiveIndex).getCount();
				communityActiveIndex++;
			}
			
			if (commentActive != null && commentActiveIndex < commentActiveIndexMax && commentActive.get(commentActiveIndex).getMonth() == index) {
				sumCount += commentActive.get(commentActiveIndex).getCount();
				commentActiveIndex++;
			}
			
			yearCountVo.setMonth(index);
			yearCountVo.setCount(sumCount);
			
			resultActive.add(yearCountVo);
		}
		
		return resultActive;
	}

}
