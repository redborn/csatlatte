package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자가 직접 입력을 통해 사용자 본인의 성적을 관리하는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/grade")
public class Grade {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 
	 * 사용자의 성적을 조회, 입력, 삭제, 수정을 하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("grade view");
		return TilesName.GRADE;
	}
	
}
