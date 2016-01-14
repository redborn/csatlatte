package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.FaqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/support")
public class Support {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FaqService faqService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="faqTypeSequence",required=true) int faqTypeSequence) {
		logger.info("data support view");
		
		model.addAttribute("list", faqService.list(faqTypeSequence));
	}

}