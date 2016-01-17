package org.redborn.csatlatte.controller.data.student.connection.stats.monthly;

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
@RequestMapping("/data/student/connection/stats/monthly")
public class MonthlyConnection {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="ym",required=true) String ym) {
		logger.info("data stats monthlyconnection view");

		model.addAttribute("monthlyConnection", studentService.monthlyConnectionCount(ym));
	}
}
