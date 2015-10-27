package org.redborn.csatlatte.controller.web.stats;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/stats/join")
public class Join {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 등급 평균 변화 그래프, 표준점수 변화 그래프 조회
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("stats join view");
		return TilesName.STATS_JOIN;
	}
}
