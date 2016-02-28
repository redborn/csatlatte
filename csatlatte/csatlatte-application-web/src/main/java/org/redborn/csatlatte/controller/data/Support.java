package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.FaqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data/support")
public class Support {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FaqService faqService;
	
	@RequestMapping(value="{faqTypeSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="faqTypeSequence") int faqTypeSequence) {
		logger.info("data support view");
		model.addAttribute("list", faqService.list(faqTypeSequence));
	}

}