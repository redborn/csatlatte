package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 수능라떼 사용자로 등록하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/join")
public class Join {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 사용자 등록에 필요한 정보를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("join view");
		return TilesName.JOIN_WRITE;
	}
	
	/**
	 * 입력한 사용자 정보 등록 처리 영역입니다.
	 * 
	 * 입력한 사용자 정보에 이상이 없는 경우 회원가입 처리 후 회원가입 완료 페이지(TilesName.JOIN_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post() {
		logger.info("join success or fail");
		return TilesName.JOIN_SUCCESS;
	}
}