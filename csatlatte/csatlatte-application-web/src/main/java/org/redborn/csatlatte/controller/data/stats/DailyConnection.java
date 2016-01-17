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
@RequestMapping("/data/stats/dailyconnection")
public class DailyConnection {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="ymd",required=true) String ymd) {
		logger.info("data stats dailyconnection view");
		
		model.addAttribute("dailyConnection", studentService.dailyConnectionCount(ymd));
	}
}
