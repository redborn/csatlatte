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

	public List<YmdCountVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("community.comment.selectListCountYmd", ymd);
	}

	public List<YmCountVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("community.comment.selectListCountYm", ym);
	}

	public List<YearCountVo> selectListCountYear(String year) {
		return getSqlSession().selectList("community.comment.selectListCountYear", year);
	}

	public List<CommentVo> selectList() {
		return getSqlSession().selectList("community.comment.selectList");
	}
	
	public int insert(CommentVo commentVo) {
		return getSqlSession().insert("community.comment.insert", commentVo);
	}

	public int update(CommentVo commentVo) {
		return getSqlSession().update("community.comment.update", commentVo);
	}

	public int updateUseYnN(int communitySequence, int commentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("commentSequence", commentSequence);
		
		return getSqlSession().update("community.comment.updateUseYnN", params);
	}

}
