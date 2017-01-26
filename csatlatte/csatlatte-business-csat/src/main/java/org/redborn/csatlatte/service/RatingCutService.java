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
	 * 모의고사 등급컷 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 등급컷 리스트
	 */
	public List<RatingCutVo> list(int csatSequence, int examSequence);
	
	/**
	 * 모의고사 등급컷을 삭제합니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 등급컷 삭제 성공 여부
	 */
	public boolean delete(int csatSequence, int examSequence);
	
	/**
	 * 모의고사 등급컷을 추가합니다.
	 * 
	 * @param sectionList 영역 리스트
	 * @param subjectList 과목 리스트
	 * @param ratingCutList 등급컷 리스트
	 * @param averageList 평균 리스트
	 * @return 등급컷 추가 성공 여부
	 */
	public boolean register(List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList);
	
	/**
	 * 모의고사 등급컷을 수정합니다.
	 * 
	 * @param sectionList 영역 리스트
	 * @param subjectList 과목 리스트
	 * @param ratingCutList 등급컷 리스트
	 * @param averageList 평균 리스트
	 * @return 등급컷 수정 성공 여부
	 */
	public boolean modify(List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList);
	
}
