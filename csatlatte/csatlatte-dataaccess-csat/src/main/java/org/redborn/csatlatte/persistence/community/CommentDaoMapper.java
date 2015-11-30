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

	public int selectOne(int communitySequence, int commentSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.comment.selectOne", params);
	}

	public List<YmdCountVo> selectOneCountYmd(String ymd) {
		return getSqlSession().selectList("community.comment.selectListCountYmd", ymd);
	}

	public List<YmCountVo> selectOneCountYm(String ym) {
		return getSqlSession().selectList("community.comment.selectListCountYm", ym);
	}

	public List<YearCountVo> selectOneCountYear(String year) {
		return getSqlSession().selectList("community.comment.selectListCountYear", year);
	}

	public List<CommentVo> selectList() {
		return getSqlSession().selectList("community.comment.selectList");
	}
	
	public int insert(CommentVo commentVo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", commentVo.getCommunitySequence());
		params.put("studentSequence", commentVo.getStudentSequence());
		params.put("content", commentVo.getContent());
		
		return getSqlSession().insert("community.comment.insert", params);
	}

	public int update(CommentVo commentVo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", commentVo.getCommunitySequence());
		params.put("commentSequence", commentVo.getCommentSequence());
		params.put("content", commentVo.getContent());
		
		return getSqlSession().update("community.comment.update", params);
	}

	public int updateUseYnN(int communitySequence, int commentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		
		return getSqlSession().update("community.comment.updateUseYnN", params);
	}

}
