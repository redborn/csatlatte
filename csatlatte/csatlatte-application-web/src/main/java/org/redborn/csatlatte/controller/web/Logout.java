package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 로그아웃입니다.
 */
@Controller
@RequestMapping("/logout")
public class Logout {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	HttpSessionValue httpSessionValue;

	/**
	 * 로그아웃입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info(new StringBuilder("logout. ID is ").append(httpSessionValue.getId()).toString());;
		httpSessionValue.invalidate();
		return "redirect:/main";
	}
	
}
