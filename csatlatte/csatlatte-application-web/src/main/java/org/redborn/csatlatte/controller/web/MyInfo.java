package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자의 정보를 조회하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/myinfo")
public class MyInfo {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 사용자의 아이디, 닉네임, 프로필 사진, 수능을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("myinfo view");
		return TilesName.MYINFO;
	}
	
}