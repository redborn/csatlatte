package org.redborn.csatlatte.controller.web.stats;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 접속자 통계입니다.
 */
@Controller
@RequestMapping("/stats/connection")
public class Connection {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 접속자 통계입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("Controller stats connection GET.");
		return TilesName.STATS_CONNECTION;
	}
}
