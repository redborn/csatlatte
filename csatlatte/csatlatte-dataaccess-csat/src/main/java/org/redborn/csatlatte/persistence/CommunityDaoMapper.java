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

	public List<YmdCountVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("community.selectListCountYmd", ymd);
	}

	public List<YmCountVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("community.selectListCountYm", ym);
	}

	public List<YearCountVo> selectListCountYear(String year) {
		return getSqlSession().selectList("community.selectListCountYear", year);
	}

	public List<CommunityVo> selectList() {
		return getSqlSession().selectList("community.selectList");
	}

	public List<CommunityVo> selectListStudentText(int studentSequence) {
		return getSqlSession().selectList("community.selectListStudentText", studentSequence);
	}

	public int insert(CommunityVo communityVo) {
		return getSqlSession().insert("community.insert", communityVo);
	}

	public int update(CommunityVo communityVo) {
		return getSqlSession().update("community.update", communityVo);
	}

	public int updateUseYnN(int communitySequence) {
		return getSqlSession().update("community.updateUseYnN", communitySequence);
	}

}
