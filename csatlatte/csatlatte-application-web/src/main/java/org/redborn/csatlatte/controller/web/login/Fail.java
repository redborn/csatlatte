package org.redborn.csatlatte.controller.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 로그인 실패에 대한 처리 controller 영역입니다.
 */
@Controller
@RequestMapping("/login/fail")
public class Fail {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 로그인을 실패하는 경우를 처리합니다. 실패한 경우 메인 페이지로 되돌아갑니다.(redirect:/main)
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(RedirectAttributes redirectAttributes) {
		logger.info("login fail");
		redirectAttributes.addFlashAttribute("fail", true);
		return "redirect:/main";
	}

}