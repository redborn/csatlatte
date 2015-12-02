package org.redborn.csatlatte.service;

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
		boolean result = false;
		
		if (blindDao.selectOne(communityTypeSequence, communitySequence) == 0) {
			if (blindDao.insert(communityTypeSequence, communitySequence, content) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public boolean write(CommunityVo communityVo) {
		return communityDao.insert(communityVo) == 1;
	}

	public boolean modify(CommunityVo communityVo) {
		boolean result = false;
		
		if (communityDao.selectOne(communityVo.getCommunityTypeSequence(), communityVo.getCommunitySequence(), communityVo.getStudentSequence()) == 1) {
			if (communityDao.update(communityVo) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence) {
		boolean result = false;
		
		if (communityDao.selectOne(communityTypeSequence, communitySequence, studentSequence) == 1) {
			if (communityDao.updateUseYnN(communityTypeSequence, communitySequence) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, String content) {
		boolean result = false;
		
		if (commentBlindDao.selectOne(communityTypeSequence, communitySequence, commentSequence) == 0) {
			if (commentBlindDao.insert(communityTypeSequence, communitySequence, commentSequence, content) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public boolean writeComment(CommentVo commentVo) {
		return commentDao.insert(commentVo) == 1;
	}

	public boolean modifyComment(CommentVo commentVo) {
		boolean result = false;
		
		if (commentDao.selectOne(commentVo.getCommunityTypeSequence(), commentVo.getCommunitySequence(), commentVo.getCommentSequence(), commentVo.getStudentSequence()) == 1) {
			if (commentDao.update(commentVo) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public boolean deleteComment(CommentVo commentVo) {
		boolean result = false;
		
		if (commentDao.selectOne(commentVo.getCommunityTypeSequence(), commentVo.getCommunitySequence(), commentVo.getCommentSequence(), commentVo.getStudentSequence()) == 1) {
			if (commentDao.updateUseYnN(commentVo.getCommunityTypeSequence(), commentVo.getCommunitySequence(), commentVo.getCommentSequence()) == 1) {
				result = true;
			}
		}
		
		return result;
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
		boolean result = false;
		
		if (reportDao.selectOne(communitySequence, studentSequence) == 0) {
			if (reportDao.insert(communityTypeSequence, communitySequence, studentSequence, reportTypeSequence) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public boolean reportComment(int studentSequence, int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence) {
		boolean result = false;
		
		if (commentReportDao.selectOne(communityTypeSequence, communitySequence, commentSequence, studentSequence) == 0) {
			if (commentReportDao.insert(communityTypeSequence, communitySequence, commentSequence, studentSequence, reportTypeSequence) == 1) {
				result = true;
			}
		}
		
		return result;
	}

	public List<YmdCountVo> dailyActive(int communityTypeSequence, String ymd) {
		List<YmdCountVo> communityActive = communityDao.selectListCountYmd(communityTypeSequence, ymd);
		List<YmdCountVo> commentActive = commentDao.selectListCountYmd(communityTypeSequence, ymd);
		List<YmdCountVo> resultActive = null;
		
		for (int index = 0; index <= 23; index++) {
			YmdCountVo initializationVo = new YmdCountVo();
			String hour = Integer.toString(index);
			int sumCount = 0;
			
			initializationVo.setHour(hour);
			initializationVo.setCount(0);
			
			resultActive.add(initializationVo);
			
			if (Integer.parseInt(communityActive.get(index).getHour()) == index) {
				YmdCountVo ymdCountVo = new YmdCountVo();
				
				sumCount = communityActive.get(index).getCount();
				
				ymdCountVo.setHour(hour);
				ymdCountVo.setCount(sumCount);
				
				resultActive.set(index, ymdCountVo);
			}
			
			if (Integer.parseInt(commentActive.get(index).getHour()) == index) {
				YmdCountVo ymdCountVo = new YmdCountVo();
				
				sumCount += commentActive.get(index).getCount();
				
				ymdCountVo.setHour(hour);
				ymdCountVo.setCount(sumCount);
				
				resultActive.set(index, ymdCountVo);
			}
			
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
