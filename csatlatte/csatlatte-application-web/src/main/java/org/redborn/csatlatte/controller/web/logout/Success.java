package org.redborn.csatlatte.controller.web.logout;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 로그아웃입니다.
 */
@Controller
@RequestMapping("/logout/success")
public class Success {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	HttpSessionValue httpSessionValue;

	/**
	 * 로그아웃입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(RedirectAttributes redirectAttributes) {
		logger.info("Controller logout success GET.");
		redirectAttributes.addFlashAttribute("logoutSuccess", true);
		return "redirect:/login";
	}
	
}