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

	public int selectOne(int communityTypeSequence, int communitySequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("communitySequence", communitySequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectOne("community.selectOne", params);
	}

	public List<YmdCountVo> selectListCountYmd(int communityTypeSequence, String ymd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ymd", ymd);
		
		return getSqlSession().selectList("community.selectListCountYmd", params);
	}

	public List<YmCountVo> selectListCountYm(int communityTypeSequence, String ym) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("ym", ym);
		
		return getSqlSession().selectList("community.selectListCountYm", params);
	}

	public List<YearCountVo> selectListCountYear(int communityTypeSequence, String year) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityTypeSequence", communityTypeSequence);
		params.put("year", year);
		
		return getSqlSession().selectList("community.selectListCountYear", params);
	}

	public List<CommunityVo> selectList(int communityTypeSequence) {
		return getSqlSession().selectList("community.selectList", communityTypeSequence);
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
