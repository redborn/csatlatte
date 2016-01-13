package org.redborn.csatlatte.controller.data.manage;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.service.ExamService;
import org.redborn.csatlatte.service.StudentService;
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
@RequestMapping("/data/manage/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="examSequence",required=true) int examSequence) {
		logger.info("data manage exam get view");
		
		model.addAttribute("yearList", examService.yearList());
		model.addAttribute("institutionList", examService.institutionList());
		model.addAttribute("ysList", studentService.ysList());
		model.addAttribute("listOne", examService.listForManageOne(examSequence));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void post(@RequestParam(value="examSequence",required=true) int examSequence,
			@RequestParam(value="csatSequence",required=true) int csatSequence,
			@RequestParam(value="examName",required=true) String examName,
			@RequestParam(value="institutionSequence",required=true) int institutionSequence,
			@RequestParam(value="ysSequence",required=true) int ysSequence) {
		logger.info("data manage exam put view");
		
		ExamVo examVo = new ExamVo();
		
		examVo.setExamSequence(examSequence);
		examVo.setCsatSequence(csatSequence);
		examVo.setExamName(examName);
		examVo.setInstitutionSequence(institutionSequence);
		examVo.setYsSequence(ysSequence);
		
		examService.modify(examVo);
	}
	
	@RequestMapping(value="{examSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int examSequence) {
		examService.delete(examSequence);
	}
}
