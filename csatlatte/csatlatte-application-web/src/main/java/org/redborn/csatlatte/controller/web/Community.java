package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자간의 소통을 하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/community")
public class Community {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 사용자 본인과 다른 사용자가 작성한 글, 댓글을 조회 및 새로운 글, 댓글을 작성, 수정하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("community view");
		return TilesName.COMMUNITY;
	}	
}