package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.CountVo;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDaoMapper extends SqlSessionDaoSupport implements CommunityDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.selectOne", params);
	}
	
	public int selectOneAmountCommunity() {
		return getSqlSession().selectOne("community.selectOneAmountCommunity");
	}

	public List<CountVo> selectListCountYmd(int communityTypeSequence, String ymd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ymd", ymd);
		
		return getSqlSession().selectList("community.selectListCountYmd", params);
	}

	public List<CountVo> selectListCountYm(int communityTypeSequence, String ym) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ym", ym);
		
		return getSqlSession().selectList("community.selectListCountYm", params);
	}

	public List<CountVo> selectListCountYear(int communityTypeSequence, String year) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("year", year);
		
		return getSqlSession().selectList("community.selectListCountYear", params);
	}

	public List<CommunityVo> selectList(int communityTypeSequence) {
		return getSqlSession().selectList("community.selectList", communityTypeSequence);
	}
	
	public List<CommunityVo> selectListForManage(int communityTypeSequence, String search, int pageNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("search", search);
		params.put("pageNumber", pageNumber);
		
		return getSqlSession().selectList("community.selectListForManage", params);
	}

	public List<CommunityVo> selectListStudentText(int communityTypeSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectList("community.selectListStudentText", params);
	}

	public int insert(CommunityVo communityVo) {
		return getSqlSession().insert("community.insert", communityVo);
	}

	public int update(CommunityVo communityVo) {
		return getSqlSession().update("community.update", communityVo);
	}

	public int updateUseYnN(int communityTypeSequence, int communitySequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		
		return getSqlSession().update("community.updateUseYnN", communitySequence);
	}

}
