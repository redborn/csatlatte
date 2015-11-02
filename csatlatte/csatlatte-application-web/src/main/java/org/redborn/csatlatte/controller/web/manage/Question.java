package org.redborn.csatlatte.controller.web.manage;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 문의를 조회하고 답변을 작성할 수 있는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/manage/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 문의목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("manage question view");
		return TilesName.MANAGE_QUESTION;
	}
}
