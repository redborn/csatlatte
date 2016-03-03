package org.redborn.csatlatte.persistence.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CountVo;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoMapper extends SqlSessionDaoSupport implements CommentDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.comment.selectOne", params);
	}

	public List<CountVo> selectListCountYmd(int communityTypeSequence, String ymd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ymd", ymd);
		
		return getSqlSession().selectList("community.comment.selectListCountYmd", params);
	}

	public List<CountVo> selectListCountYm(int communityTypeSequence, String ym) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ym", ym);
		
		return getSqlSession().selectList("community.comment.selectListCountYm", params);
	}

	public List<CountVo> selectListCountYear(int communityTypeSequence, String year) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("year", year);
		
		return getSqlSession().selectList("community.comment.selectListCountYear", params);
	}

	public List<CommentVo> selectList(int communityTypeSequence, int communitySequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectList("community.comment.selectList", params);
	}
	
	public int insert(CommentVo commentVo, String userAgent, String sessionId, String ip) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", commentVo.getCommunityTypeSequence());
		params.put("communitySequence", commentVo.getCommunitySequence());
		params.put("studentSequence", commentVo.getStudentSequence());
		params.put("content", commentVo.getContent());
		params.put("userAgent", userAgent);
		params.put("sessionId", sessionId);
		params.put("ip", ip);
		return getSqlSession().insert("community.comment.insert", params);
	}

	public int updateUseYnN(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().update("community.comment.updateUseYnN", params);
	}

}
