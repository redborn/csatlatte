package org.redborn.csatlatte.persistence.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
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

	public List<YmdCountVo> selectListCountYmd(int communityTypeSequence, String ymd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ymd", ymd);
		
		return getSqlSession().selectList("community.comment.selectListCountYmd", params);
	}

	public List<YmCountVo> selectListCountYm(int communityTypeSequence, String ym) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ym", ym);
		
		return getSqlSession().selectList("community.comment.selectListCountYm", params);
	}

	public List<YearCountVo> selectListCountYear(int communityTypeSequence, String year) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("year", year);
		
		return getSqlSession().selectList("community.comment.selectListCountYear", params);
	}

	public List<CommentVo> selectList(int communitySequence, int communityTypeSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("communityTypeSequence", communityTypeSequence);
		
		return getSqlSession().selectList("community.comment.selectList", params);
	}
	
	public int insert(CommentVo commentVo) {
		return getSqlSession().insert("community.comment.insert", commentVo);
	}

	public int update(CommentVo commentVo) {
		return getSqlSession().update("community.comment.update", commentVo);
	}

	public int updateUseYnN(int communityTypeSequence, int communitySequence, int commentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		
		return getSqlSession().update("community.comment.updateUseYnN", params);
	}

}
