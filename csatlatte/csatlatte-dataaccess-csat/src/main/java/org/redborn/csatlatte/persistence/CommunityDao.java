package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface CommunityDao {

	public int selectOne(int communitySequence, int studentSequence);
	public List<YmdCountVo> selectOneCountYmd(String ymd);
	public List<YmCountVo> selectOneCountYm(String ym);
	public List<YearCountVo> selectOneCountYear(String year);
	public List<CommunityVo> selectList();
	public List<CommunityVo> selectListStudentText(int studentSequence);
	public int insert(int studentSequence, String content);
	public int update(int communitySequence, String content);
	public int updateUseYnN(int communitySequence);
	
}
