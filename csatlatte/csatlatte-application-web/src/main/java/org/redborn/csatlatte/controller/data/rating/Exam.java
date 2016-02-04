package org.redborn.csatlatte.controller.data.rating;

import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data/rating/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{yearStudentSequence}/{year}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence,
			@PathVariable(value="year") String year) {
		logger.info("data rating exam get view");
		model.addAttribute("list", examService.list(year, yearStudentSequence));
	}
	
}
