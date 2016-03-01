package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

/**
 * 모의고사 등급컷 서비스입니다.
 */
public interface RatingCutService {

	/**
	 * 모의고사 등급컷 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public List<RatingCutVo> list(int csatSequence, int examSequence);
	
	/**
	 * 모의고사 등급컷 삭제입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public boolean delete(int csatSequence, int examSequence);
	
	/**
	 * 모의고사 등급컷 추가
	 * 
	 * @param sectionList 영역 목록
	 * @param subjectList 과목 목록
	 * @param ratingCutList 등급컷 목록
	 * @param averageList 평균 목록
	 * @return
	 */
	public boolean register(List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList);
	
}
