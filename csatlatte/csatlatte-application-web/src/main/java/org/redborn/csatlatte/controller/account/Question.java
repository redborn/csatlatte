package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자가 문의한 목록을 조회하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/{id}/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 문의사항의 제목 목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("myinfo question list");
		return TilesName.PROFILE_QUESTION_LIST;
	}

	/**
	 * 문의 제목, 문의 내용, 문의에 대한 답변의 상세 내용을 조회하는 페이지(TilesName.MYINFO_QUESTION_DETAIL)입니다.
	 */
	@RequestMapping(value="{questionSequence}",method=RequestMethod.GET)
	public String getDetail(@PathVariable int questionSequence) {
		logger.info("myinfo question detail");
		return TilesName.PROFILE_QUESTION_DETAIL;
	}

}