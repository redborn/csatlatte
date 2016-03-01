package org.redborn.csatlatte.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 에러 페이지입니다.
 */
@Controller
@RequestMapping("/error/*")
public class Error {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 에러 페이지입니다.
	 */
	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public String get(@PathVariable String code) {
		logger.info("error " + code);
		return "/error/" + code;
	}
}