package org.redborn.csatlatte.controller.data.stats;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/stats/join")
public class Join {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="date",required=true) String date,
			@RequestParam(value="item",required=true) int item) {
		logger.info("data stats join view");
		
		switch(item) {
		case 1:
			model.addAttribute("dailyJoin", studentService.dailyJoinCountList(date));
			break;
		case 2:
			model.addAttribute("monthlyJoin", studentService.monthlyJoinCountList(date));
			break;
		case 3:
			model.addAttribute("annualJoin", studentService.annualJoinCountList(date));
			break;
		}
	}

}
