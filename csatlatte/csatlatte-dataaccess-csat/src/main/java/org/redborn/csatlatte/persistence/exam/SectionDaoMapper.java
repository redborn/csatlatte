package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SectionVo;
import org.springframework.stereotype.Repository;

@Repository
public class SectionDaoMapper extends SqlSessionDaoSupport implements SectionDao {

	public int selectOneCount(SectionVo sectionVo) {
		return getSqlSession().selectOne("exam.section.selectOneCount", sectionVo);
	}
	
	public List<SectionVo> selectList(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		return getSqlSession().selectList("exam.section.selectList", params);
	}
	
	public List<SectionVo> selectListForModifyRatingCut(List<SectionVo> sectionList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sectionList", sectionList);
		return getSqlSession().selectList("exam.section.selectListForModifyRatingCut", params);
	}
	
	public int insert(SectionVo sectionVo) {
		return getSqlSession().insert("exam.section.insert", sectionVo);
	}
	
	public int update(SectionVo sectionVo) {
		return getSqlSession().update("exam.section.update", sectionVo);
	}
	
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("exam.section.delete", params);
	}
	
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sectionList", sectionList);
		return getSqlSession().delete("exam.section.deleteForModifyRatingCutBySection", params);
	}

}
