package org.redborn.csatlatte.controller.web;

import java.util.List;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.TextVo;
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
@RequestMapping("/randomsolving")
public class Randomsolving {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model, @RequestParam(value="yearStudentSequence", required=true) List<Integer> yearStudentSequence,
			@RequestParam(value="subjectSequence", required=true) List<Integer> subjectSequence) {
		logger.info("Controller randomsolving GET.");
		QuestionVo randomQuestion = examService.getRandomQuestion(yearStudentSequence, subjectSequence);
		model.addAttribute("randomQuestion", randomQuestion);
		model.addAttribute("subjectName", examService.getSubjectName(randomQuestion.getCsatSequence(), randomQuestion.getExamSequence(), randomQuestion.getSectionSequence(), randomQuestion.getSubjectSequence()));
		TextVo randomQuestionText = examService.getText(randomQuestion.getCsatSequence(), randomQuestion.getExamSequence(), randomQuestion.getSectionSequence(), randomQuestion.getSubjectSequence(), randomQuestion.getQuestionSequence());
		if (randomQuestionText != null) {
			model.addAttribute("randomQuestionText", randomQuestionText);
		}
		return TilesName.RANDOMSOLVING_QUESTION;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="questionCsatSequence", required=true) int csatSequence, @RequestParam(value="questionExamSequence", required=true) int examSequence,
			@RequestParam(value="questionSectionSequence", required=true) int sectionSequence, @RequestParam(value="questionSubjectSequence", required=true) int subjectSequence, @RequestParam(value="questionSequence", required=true) int questionSequence,
			@RequestParam(value="answer", required=false, defaultValue="0") int answer) {
		logger.info("Controller randomsolving POST.");
		model.addAttribute("subjectName", examService.getSubjectName(csatSequence, examSequence, sectionSequence, subjectSequence));
		model.addAttribute("randomQuestion", examService.question(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		model.addAttribute("marking", examService.marking(answer, csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		model.addAttribute("correctAnswer", examService.objectQuestionCorrectAnswer(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		model.addAttribute("randomQuestionText", examService.getText(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		return TilesName.RANDOMSOLVING_RESULT;
	}

}
