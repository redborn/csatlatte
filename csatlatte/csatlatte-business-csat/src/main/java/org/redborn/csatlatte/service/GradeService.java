package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.GradeListVo;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardScoreVo;
import org.redborn.csatlatte.domain.GradeVo;

/**
 * 성적 서비스입니다.
 */
public interface GradeService {
	
	/**
	 * 성적 추가입니다.
	 * 
	 * @param gradeVo 성적 값
	 * @return
	 */
	public boolean register(GradeVo gradeVo);
	
	/**
	 * 성적 수정입니다.
	 * 
	 * @param gradeVo 성적 값
	 * @return
	 */
	public boolean modify(GradeVo gradeVo);
	
	
	/**
	 * 성적 삭제입니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return
	 */
	public boolean delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 성적 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public List<GradeListVo> list(int csatSequence, int examSequence, int studentSequence);
	
	/**
	 * 등급 성적 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public List<GradeRatingVo> ratingCutList(int csatSequence, int studentSequence);
	
	/**
	 * 표준점수 성적 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public List<GradeStandardScoreVo> standardScoreList(int csatSequence, int studentSequence);
	
}
