package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.springframework.stereotype.Repository;

@Repository
public class RatingCutDaoMapper extends SqlSessionDaoSupport implements
		RatingCutDao {

	public int selectOneCount(RatingCutVo ratingCutVo) {
		return getSqlSession().selectOne("exam.ratingcut.selectOneCount", ratingCutVo);
	}
	
	public int selectOneRatingByScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("score", score);
		return getSqlSession().selectOne("exam.ratingcut.selectOneRatingByScore", params);
	}
	
	public List<ExamVo> selectList(int csatSequence) {
		return getSqlSession().selectList("exam.ratingcut.selectList", csatSequence);
	}
	
	public List<RatingCutVo> selectListDetail(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.ratingcut.selectListDetail", params);
	}
	
	public List<ExamVo> selectListForCreate(int csatSequence) {
		return getSqlSession().selectList("exam.ratingcut.selectListForCreate", csatSequence);
	}
	
	public List<RatingCutVo> selectListForModifyRatingCut(List<RatingCutVo> ratingCutList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ratingCutList", ratingCutList);
		return getSqlSession().selectList("exam.ratingcut.selectListForModifyRatingCut", params);
	}
	
	public int delete(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.ratingcut.delete", params);
	}

	public int insert(RatingCutVo ratingCutVo) {
		return getSqlSession().insert("exam.ratingcut.insert", ratingCutVo);
	}
	
	public int update(RatingCutVo ratingCutVo) {
		return getSqlSession().update("exam.ratingcut.update", ratingCutVo);
	}
	
	public int delete(int csatSequence, int examSequence, int sectionSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		return getSqlSession().delete("exam.ratingcut.delete2", params);
	}
	
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().delete("exam.ratingcut.delete3", params);
	}
	
}
