package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface CommunityDao {

	public int selectOne(int communitySequence, int studentSequence);
	public List<YmdCountVo> selectListCountYmd(String ymd);
	public List<YmCountVo> selectListCountYm(String ym);
	public List<YearCountVo> selectListCountYear(String year);
	public List<CommunityVo> selectList();
	public List<CommunityVo> selectListStudentText(int studentSequence);
	public int insert(CommunityVo communityVo);
	public int update(CommunityVo communityVo);
	public int updateUseYnN(int communitySequence);
	
}
