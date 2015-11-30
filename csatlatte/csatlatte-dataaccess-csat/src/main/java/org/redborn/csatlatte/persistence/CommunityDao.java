package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface CommunityDao {

	public int selectOne(int communityTypeSequence, int communitySequence, int studentSequence);
	public List<YmdCountVo> selectListCountYmd(int communityTypeSequence, String ymd);
	public List<YmCountVo> selectListCountYm(int communityTypeSequence, String ym);
	public List<YearCountVo> selectListCountYear(int communityTypeSequence, String year);
	public List<CommunityVo> selectList(int communityTypeSequence);
	public List<CommunityVo> selectListStudentText(int communityTypeSequence, int studentSequence);
	public int insert(CommunityVo communityVo);
	public int update(CommunityVo communityVo);
	public int updateUseYnN(int communityTypeSequence, int communitySequence);
	
}
