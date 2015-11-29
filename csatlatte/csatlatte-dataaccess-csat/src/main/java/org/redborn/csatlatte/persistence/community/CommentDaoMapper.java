package org.redborn.csatlatte.persistence.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
import org.redborn.csatlatte.persistence.CommunityDao;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoMapper extends SqlSessionDaoSupport implements CommunityDao {

	public int selectOne(int communitySequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.comment.selectOne", params);
	}

	public List<YmdCountVo> selectOneCountYmd(String ymd) {
		return getSqlSession().selectOne("community.comment.selectOneCountYmd", ymd);
	}

	public List<YmCountVo> selectOneCountYm(String ym) {
		return getSqlSession().selectOne("community.comment.selectOneCountYm", ym);
	}

	public List<YearCountVo> selectOneCountYear(String year) {
		return getSqlSession().selectOne("community.comment.selectOneCountYear", year);
	}

	public List<CommunityVo> selectList() {
		return getSqlSession().selectList("community.comment.selectList");
	}

	public List<CommunityVo> selectListStudentText(int studentSequence) {
		return getSqlSession().selectList("community.comment.selectListStudentText", studentSequence);
	}

	public int insert(int studentSequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("content", content);
		
		return getSqlSession().insert("community.comment.insert", params);
	}

	public int update(int communitySequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("content", content);
		
		return getSqlSession().update("community.comment.update", params);
	}

	public int updateUseYnN(int communitySequence) {
		return getSqlSession().update("community.comment.updateUseYnN", communitySequence);
	}

}
