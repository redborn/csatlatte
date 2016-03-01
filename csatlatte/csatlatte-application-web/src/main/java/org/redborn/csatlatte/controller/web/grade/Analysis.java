package org.redborn.csatlatte.controller.web.grade;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 성적분석 controller 영역입니다.
 */
@Controller
@RequestMapping("/grade/analysis")
public class Analysis {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 등급 평균 변화 그래프, 표준점수 변화 그래프 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("grade analysis view");
		return TilesName.GRADE_ANALYSIS;
	}
}
