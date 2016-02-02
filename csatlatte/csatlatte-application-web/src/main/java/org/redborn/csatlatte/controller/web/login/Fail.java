package org.redborn.csatlatte.controller.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login/fail")
public class Fail {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(RedirectAttributes redirectAttributes) {
		logger.info("login fail");
		redirectAttributes.addFlashAttribute("fail", true);
		return "redirect:/main";
	}

}