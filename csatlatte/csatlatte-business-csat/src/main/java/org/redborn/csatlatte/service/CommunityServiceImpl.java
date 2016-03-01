package org.redborn.csatlatte.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.TypeVo;
import org.redborn.csatlatte.persistence.CommunityDao;
import org.redborn.csatlatte.persistence.community.BlindDao;
import org.redborn.csatlatte.persistence.community.CommentDao;
import org.redborn.csatlatte.persistence.community.ReportDao;
import org.redborn.csatlatte.persistence.community.comment.CommentBlindDao;
import org.redborn.csatlatte.persistence.community.comment.CommentReportDao;
import org.redborn.csatlatte.persistence.report.TypeDao;
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
	@Autowired
	private TypeDao reportTypeDao;
	@Autowired
	private org.redborn.csatlatte.persistence.blind.TypeDao blindTypeDao;
	
	public int getCount(String search) {
		return communityDao.selectOneCount(search);
	}
	
	public boolean blind(int communityTypeSequence, int communitySequence, int blindTypeSequence) {
		return blindDao.selectOne(communityTypeSequence, communitySequence) == 0 
				&& blindDao.insert(communityTypeSequence, communitySequence, blindTypeSequence) == 1;
	}

	public boolean write(CommunityVo communityVo, String userAgent, String sessionId, String ip) {
		return communityDao.insert(communityVo, userAgent, sessionId, ip) == 1;
	}

	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence) {
		return communityDao.selectOne(communityTypeSequence, communitySequence, studentSequence) == 1 
				&& communityDao.updateUseYnN(communityTypeSequence, communitySequence) == 1;
	}

	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, int blindTypeSequence) {
		return commentBlindDao.selectOne(communityTypeSequence, communitySequence, commentSequence) == 0 
				&& commentBlindDao.insert(communityTypeSequence, communitySequence, commentSequence, blindTypeSequence) == 1;
	}

	public boolean writeComment(CommentVo commentVo, String userAgent, String sessionId, String ip) {
		return commentDao.insert(commentVo, userAgent, sessionId, ip) == 1;
	}

	public boolean deleteComment(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence) {
		return commentDao.updateUseYnN(communityTypeSequence,communitySequence, commentSequence, studentSequence) == 1;
	}

	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence) {
		return list(communityTypeSequence, start, end, limit, studentSequence, 0);
	}
	
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence, int searchStudentSequence) {
		return communityDao.selectList(communityTypeSequence, start, end, limit, studentSequence, searchStudentSequence);
	}
	
	public List<CommunityVo> list(int communityTypeSequence, String search, int pageNumber) {
		return communityDao.selectListForManage(communityTypeSequence, search, pageNumber);
	}

	public List<CommunityVo> list(int communityTypeSequence, int studentSequence) {
		return communityDao.selectListStudentText(communityTypeSequence, studentSequence);
	}

	public List<CommentVo> commentList(int communityTypeSequence, int communitySequence, int studentSequence) {
		return commentDao.selectList(communityTypeSequence, communitySequence, studentSequence);
	}

	public List<TypeVo> blindTypeList() {
		return blindTypeDao.selectList();
	}

	public List<TypeVo> reportTypeList() {
		return reportTypeDao.selectList();
	}

	public boolean report(int studentSequence, int communityTypeSequence, int communitySequence, int reportTypeSequence, String userAgent, String sessionId, String ip) {
		return reportDao.selectOne(communitySequence, studentSequence) == 0
				&& reportDao.insert(communityTypeSequence, communitySequence, studentSequence, reportTypeSequence, userAgent, sessionId, ip) == 1;
	}

	public boolean reportComment(int studentSequence, int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence, String userAgent, String sessionId, String ip) {
		return commentReportDao.selectOne(communityTypeSequence, communitySequence, commentSequence, studentSequence) == 0
				&& commentReportDao.insert(communityTypeSequence, communitySequence, commentSequence, studentSequence, reportTypeSequence, userAgent, sessionId, ip) == 1;
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
	
	public CommunityVo detail(int communityTypeSequence, int communitySequence) {
		return communityDao.selectOneDetail(communityTypeSequence, communitySequence);
	}

}
