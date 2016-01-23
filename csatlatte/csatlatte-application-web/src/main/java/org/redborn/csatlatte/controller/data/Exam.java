package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/exam")
public class Exam {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="csatSequence",required=true) int csatSequence,
			@RequestParam(value="examSequence",required=true) int examSequence) {
		logger.info("data exam get view");
		
		model.addAttribute("checkForDelete", examService.checkForDelete(csatSequence, examSequence));
	}
}
