package org.redborn.csatlatte.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class Login {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 사용자 등록에 필요한 정보를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String get() {
		logger.info("login");
		return "redirect:/main";
	}

}
