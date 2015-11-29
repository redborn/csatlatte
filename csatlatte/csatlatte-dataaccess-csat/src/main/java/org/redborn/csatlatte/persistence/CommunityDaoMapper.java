package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDaoMapper extends SqlSessionDaoSupport implements CommunityDao {

	public int selectOne(int communitySequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.selectOne", params);
	}

	public List<YmdCountVo> selectOneCountYmd(String ymd) {
		return getSqlSession().selectOne("community.selectOneCountYmd", ymd);
	}

	public List<YmCountVo> selectOneCountYm(String ym) {
		return getSqlSession().selectOne("community.selectOneCountYm", ym);
	}

	public List<YearCountVo> selectOneCountYear(String year) {
		return getSqlSession().selectOne("community.selectOneCountYear", year);
	}

	public List<CommunityVo> selectList() {
		return getSqlSession().selectList("community.selectList");
	}

	public List<CommunityVo> selectListStudentText(int studentSequence) {
		return getSqlSession().selectList("community.selectListStudentText", studentSequence);
	}

	public int insert(int studentSequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("content", content);
		
		return getSqlSession().insert("community.insert", params);
	}

	public int update(int communitySequence, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communitySequence", communitySequence);
		params.put("content", content);
		
		return getSqlSession().update("community.update", params);
	}

	public int updateUseYnN(int communitySequence) {
		return getSqlSession().update("community.updateUseYnN", communitySequence);
	}

}
