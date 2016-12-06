package org.redborn.csatlatte.controller.web;

import java.io.IOException;
import java.util.List;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.ExamService;
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
@RequestMapping("/solving")
public class Solving {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{csatSequence}/{examSequence}/{sectionSequence}/{subjectSequence}",method=RequestMethod.GET)
	public String get(Model model, @PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence, @PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence, @RequestParam(value="examTime",required=false,defaultValue="false") boolean examTime) {
		logger.info("Controller solving GET.");
		model.addAttribute("csatSequence", csatSequence);
		model.addAttribute("examSequence", examSequence);
		model.addAttribute("sectionSequence", sectionSequence);
		model.addAttribute("subjectSequence", subjectSequence);
		boolean isListeningFile = examService.checkListeningFile(csatSequence, examSequence, sectionSequence, subjectSequence);
		model.addAttribute("isListeningFile", isListeningFile);
		if (isListeningFile) {
			try {
				model.addAttribute("listeningFileSize", examService.getInputStream(csatSequence, examSequence, sectionSequence, subjectSequence).available());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("textList", examService.textList(csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("examName", examService.getName(csatSequence, examSequence));
		model.addAttribute("subjectName", examService.getSubjectName(csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("questionList", examService.questionList(csatSequence, examSequence, sectionSequence, subjectSequence));
		if (examTime) {
			model.addAttribute("examTime", examService.getExamTime(csatSequence, examSequence, sectionSequence, subjectSequence));
		}
		return TilesName.SOLVING_LIST;
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}/{sectionSequence}/{subjectSequence}",method=RequestMethod.POST)
	public String post(Model model, @PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence, 
			@PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence, 
			@RequestParam(value="result", required=true) List<Integer> questionNumber) {
		logger.info("Controller solving POST.");
		int score = examService.calculateScore(questionNumber, csatSequence, examSequence, sectionSequence, subjectSequence);
		model.addAttribute("questionNumber", questionNumber);
		model.addAttribute("correctAnswerList", examService.objectQuestionCorrectAnswerList(csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("questionList", examService.questionList(csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("marking", examService.marking(questionNumber, csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("rating", examService.calculateRating(score, csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("standardScore", examService.calculateStandardScore(score, csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("score", score);
		model.addAttribute("textList", examService.textList(csatSequence, examSequence, sectionSequence, subjectSequence));
		
		return TilesName.SOLVING_RESULT;
	}

}