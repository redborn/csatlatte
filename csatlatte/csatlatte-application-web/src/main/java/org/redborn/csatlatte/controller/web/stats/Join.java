package org.redborn.csatlatte.controller.web.stats;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 가입자 통계에 대한 controller 영역입니다.
 */
@Controller
@RequestMapping("/stats/join")
public class Join {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 가입자 통계 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("stats join view");
		return TilesName.STATS_JOIN;
	}
}
