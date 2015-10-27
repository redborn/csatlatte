package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 모의고사 등급컷을 조회하는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/rating")
public class Rating {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 모의고사 등급컷을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("rating view");
		return TilesName.RATING;
	}
	
}
