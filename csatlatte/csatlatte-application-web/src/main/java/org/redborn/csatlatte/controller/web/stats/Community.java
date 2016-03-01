package org.redborn.csatlatte.controller.web.stats;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 커뮤니티 통계에 대한 controller 영역입니다.
 */
@Controller
@RequestMapping("/stats/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 커뮤니티 활성도 통계 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("stats community view");
		return TilesName.STATS_COMMUNITY;
	}
}
