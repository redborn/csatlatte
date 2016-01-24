package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.springframework.stereotype.Repository;

@Repository
public class RatingDaoMapper extends SqlSessionDaoSupport implements RatingDao {

	public int selectOne(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectOne("rating.selectOneCount", params);
	}
	
	public List<ExamVo> selectList(int csatSequence) {
		return getSqlSession().selectList("rating.selectList", csatSequence);
	}
	
	public List<ExamVo> selectListForCreate(int csatSequence) {
		return getSqlSession().selectList("rating.selectListForCreate", csatSequence);
	}
	
	public int deleteAverage(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("rating.deleteAverage", params);
	}
	
	public int deleteSection(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("rating.deleteSection", params);
	}
	
	public int deleteSubject(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("rating.deleteSubject", params);
	}
	
	public int deleteRatingCut(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("rating.deleteRatingCut", params);
	}
	
	public int deleteStudentScore(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("rating.deleteStudentScore", params);
	}
}
