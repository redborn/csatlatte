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
import org.springframework.web.bind.annotation.PathVariable;
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
	public String get(Model model, @RequestParam(value="yearStudentSequenceList", required=true) List<Integer> yearStudentSequenceList,
			@RequestParam(value="subjectSequenceList", required=true) List<Integer> subjectSequenceList) {
		logger.info("Controller randomsolving GET.");
		QuestionVo randomQuestion = examService.randomQuestion(yearStudentSequenceList, subjectSequenceList);
		model.addAttribute("yearStudentSequenceList", yearStudentSequenceList);
		model.addAttribute("subjectSequenceList", subjectSequenceList);
		model.addAttribute("randomQuestion", randomQuestion);
		TextVo randomQuestionText = examService.text(randomQuestion.getCsatSequence(), randomQuestion.getExamSequence(), randomQuestion.getSectionSequence(), randomQuestion.getSubjectSequence(), randomQuestion.getQuestionSequence());
		if (randomQuestionText != null) {
			model.addAttribute("randomQuestionText", randomQuestionText);
		}
		return TilesName.RANDOMSOLVING_QUESTION;
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}/{sectionSequence}/{subjectSequence}/{questionSequence}",method=RequestMethod.POST)
	public String get(Model model, @PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence,
			@PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence, @PathVariable(value="questionSequence") int questionSequence,
			@RequestParam(value="answer", required=false, defaultValue="0") int answer) {
		logger.info("Controller randomsolving POST.");
		model.addAttribute("randomQuestion", examService.question(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		model.addAttribute("marking", examService.marking(answer, csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		model.addAttribute("correctAnswer", examService.objectQuestionCorrectAnswer(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		model.addAttribute("randomQuestionText", examService.text(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence));
		return TilesName.RANDOMSOLVING_RESULT;
	}

}
