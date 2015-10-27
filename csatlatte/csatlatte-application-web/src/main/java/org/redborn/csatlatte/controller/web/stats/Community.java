package org.redborn.csatlatte.controller.web.stats;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stats/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("stats community view");
		return TilesName.STATS_COMMUNITY;
	}
}
