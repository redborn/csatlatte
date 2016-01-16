package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.service.GradeService;
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
@RequestMapping("/data/grade")
public class Grade {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GradeService gradeService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	@RequestMapping(value="{examSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="examSequence") int examSequence) {
		logger.info("data grade list");
		model.addAttribute("list", gradeService.list(httpSessionValue.getCsatSequence(), examSequence, httpSessionValue.getStudentSequence()));
	}
	
	@RequestMapping(value="{examSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="examSequence") int examSequence, @RequestParam(value="score",required=true) int score, @RequestParam(value="sectionSequence",required=true) int sectionSequence, @RequestParam(value="subjectSequence",required=true) int subjectSequence) {
		logger.info("data grade register");
		GradeVo gradeVo = new GradeVo();
		gradeVo.setCsatSequence(httpSessionValue.getCsatSequence());
		gradeVo.setStudentSequence(httpSessionValue.getStudentSequence());
		gradeVo.setExamSequence(examSequence);
		gradeVo.setScore(score);
		gradeVo.setSectionSequence(sectionSequence);
		gradeVo.setSubjectSequence(subjectSequence);
		model.addAttribute("result", gradeService.register(gradeVo));
	}
	
	@RequestMapping(value="{examSequence}",method=RequestMethod.PUT)
	public void put(Model model, @PathVariable(value="examSequence") int examSequence, @RequestParam(value="score",required=true) int score, @RequestParam(value="sectionSequence",required=true) int sectionSequence, @RequestParam(value="subjectSequence",required=true) int subjectSequence) {
		logger.info("data grade modify");
		GradeVo gradeVo = new GradeVo();
		gradeVo.setCsatSequence(httpSessionValue.getCsatSequence());
		gradeVo.setStudentSequence(httpSessionValue.getStudentSequence());
		gradeVo.setExamSequence(examSequence);
		gradeVo.setScore(score);
		gradeVo.setSectionSequence(sectionSequence);
		gradeVo.setSubjectSequence(subjectSequence);
		model.addAttribute("result", gradeService.modify(gradeVo));
	}

	@RequestMapping(value="{examSequence}",method=RequestMethod.DELETE)
	public void put(Model model, @PathVariable(value="examSequence") int examSequence, @RequestParam(value="sectionSequence",required=true) int sectionSequence, @RequestParam(value="subjectSequence",required=true) int subjectSequence) {
		logger.info("data grade delete");
		model.addAttribute("result", gradeService.delete(httpSessionValue.getStudentSequence(), httpSessionValue.getCsatSequence(), examSequence, sectionSequence, subjectSequence));
	}
	
}