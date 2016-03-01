package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 메인페이지입니다.
 */
@Controller
@RequestMapping("/main")
public class Main {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 메인페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("main view");
		return TilesName.MAIN;
	}
}
