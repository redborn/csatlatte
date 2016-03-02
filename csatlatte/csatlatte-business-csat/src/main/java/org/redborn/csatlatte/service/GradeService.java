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
	 * 성적을 추가합니다.
	 * 
	 * @param gradeVo 성적 값
	 * @return 성적 추가 성공 여부
	 */
	public boolean register(GradeVo gradeVo);
	
	/**
	 * 성적을 수정합니다.
	 * 
	 * @param gradeVo 성적 값
	 * @return 성적 수정 성공 여부
	 */
	public boolean modify(GradeVo gradeVo);
	
	
	/**
	 * 성적을 삭제합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 성적 삭제 성공 여부
	 */
	public boolean delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 성적 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 성적 리스트
	 */
	public List<GradeListVo> list(int csatSequence, int examSequence, int studentSequence);
	
	/**
	 * 등급 성적 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 등급 성적 리스트
	 */
	public List<GradeRatingVo> ratingCutList(int csatSequence, int studentSequence);
	
	/**
	 * 표준점수 성적 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 표준점수 성적 리스트
	 */
	public List<GradeStandardScoreVo> standardScoreList(int csatSequence, int studentSequence);
	
}
