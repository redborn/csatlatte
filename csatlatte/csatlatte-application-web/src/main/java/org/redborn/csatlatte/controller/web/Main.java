package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 수능라떼 웹사이트의 첫 페이지입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/main")
public class Main {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 수능라뗴 메인 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("main view");
		return TilesName.MAIN;
	}
}
