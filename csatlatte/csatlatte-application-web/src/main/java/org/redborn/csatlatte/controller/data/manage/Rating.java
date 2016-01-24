package org.redborn.csatlatte.controller.data.manage;

import org.redborn.csatlatte.service.ExamService;
import org.redborn.csatlatte.service.RatingCutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/manage/rating")
public class Rating {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private RatingCutService ratingCutService;
	
	@RequestMapping(value="{csatSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence) {
		logger.info("data manage rating get view");
		model.addAttribute("list",examService.listForRatingManage(csatSequence));
		model.addAttribute("listForCreate",examService.listForRatingCreate(csatSequence));
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET)
	public void detail(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence, 
			@RequestParam(value="upperRatingCode",required=true) int upperRatingCode,
			@RequestParam(value="lowerRatingCode",required=true) int lowerRatingCode) {
		logger.info("data manage rating detail view");
		
		model.addAttribute("list", ratingCutService.list(csatSequence, examSequence, upperRatingCode, lowerRatingCode));
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="csatSequence") int csatSequence, 
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage rating delete");
		examService.deleteStudentScore(csatSequence, examSequence);
		examService.deleteRatingCut(csatSequence, examSequence);
		examService.deleteAverage(csatSequence, examSequence);
		examService.deleteSubject(csatSequence, examSequence);
		examService.deleteSection(csatSequence, examSequence);
	}
	
}
