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

	public List<ExamVo> selectList(int csatSequence) {
		return getSqlSession().selectList("exam.ratingcut.selectList", csatSequence);
	}
	
	public List<RatingCutVo> selectListDetail(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.ratingcut.selectListDetail", params);
	}
	
	public List<RatingCutVo> selectListDetailForSolving(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().selectList("exam.ratingcut.selectListDetailForSolving", params);
	}

	
	public List<ExamVo> selectListForCreate(int csatSequence) {
		return getSqlSession().selectList("exam.ratingcut.selectListForCreate", csatSequence);
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

}
