package org.redborn.csatlatte.controller.data.manage;

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
@RequestMapping("/data/manage/rating")
public class Rating {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{csatSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable int csatSequence) {
		logger.info("data manage rating get view");
		model.addAttribute("list",examService.listForRatingManage(csatSequence));
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int csatSequence, @PathVariable int examSequence) {
		logger.info("data manage rating delete");
		examService.deleteStudentScore(csatSequence, examSequence);
		examService.deleteRatingCut(csatSequence, examSequence);
		examService.deleteAverage(csatSequence, examSequence);
		examService.deleteSubject(csatSequence, examSequence);
		examService.deleteSection(csatSequence, examSequence);
	}
	
}
