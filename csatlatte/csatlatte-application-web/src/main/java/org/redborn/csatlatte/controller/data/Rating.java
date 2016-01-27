package org.redborn.csatlatte.controller.data;

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

@Controller
@RequestMapping("/data/rating")
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
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage rating detail view");
		
		model.addAttribute("list", ratingCutService.list(csatSequence, examSequence));
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="csatSequence") int csatSequence, 
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage rating delete");
		ratingCutService.deleteStudentScore(csatSequence, examSequence);
		ratingCutService.deleteRatingCut(csatSequence, examSequence);
		ratingCutService.deleteAverage(csatSequence, examSequence);
		ratingCutService.deleteSubject(csatSequence, examSequence);
		ratingCutService.deleteSection(csatSequence, examSequence);
	}
	
}
