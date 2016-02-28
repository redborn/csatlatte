package org.redborn.csatlatte.controller.data.student.join.stats;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data/student/join/stats/annual")
public class Annual {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="{year}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="year") String year) {
		logger.info("data stats annualjoin view");
		
		model.addAttribute("annualJoin", studentService.annualJoinCountList(year));
	}
}
