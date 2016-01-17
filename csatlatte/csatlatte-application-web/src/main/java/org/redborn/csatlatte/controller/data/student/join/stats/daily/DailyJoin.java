package org.redborn.csatlatte.controller.data.student.join.stats.daily;

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
@RequestMapping("/data/student/join/stats/daily")
public class DailyJoin {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="ymd",required=true) String ymd) {
		logger.info("data stats dailyjoin view");
		
		model.addAttribute("dailyJoin", studentService.dailyJoinCountList(ymd));
	}
}
