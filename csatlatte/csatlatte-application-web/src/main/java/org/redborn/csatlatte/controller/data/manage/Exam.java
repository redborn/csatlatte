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
	
	@RequestMapping(value="{csatSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable int csatSequence) {
		logger.info("data manage exam get view");
		
		model.addAttribute("list", examService.listForManage(csatSequence));
	}
	
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET) 
	public void detail(Model model, @PathVariable int examSequence,
			@PathVariable int csatSequence) {
		logger.info("data manage exam detail view");

		model.addAttribute("detail", examService.detail(csatSequence, examSequence));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void post(@RequestParam(value="examSequence",required=true) int examSequence,
			@RequestParam(value="csatSequence",required=true) int csatSequence,
			@RequestParam(value="examName",required=true) String examName,
			@RequestParam(value="institutionSequence",required=true) int institutionSequence,
			@RequestParam(value="ysSequence",required=true) int ysSequence,
			@RequestParam(value="ymd",required=true) String ymd) {
		logger.info("data manage exam post view");
		
		ExamVo examVo = new ExamVo();
		
		examVo.setExamSequence(examSequence);
		examVo.setCsatSequence(csatSequence);
		examVo.setExamName(examName);
		examVo.setInstitutionSequence(institutionSequence);
		examVo.setYsSequence(ysSequence);
		examVo.setYmd(ymd);
		
		examService.modify(examVo);
	}
	
	@RequestMapping(value="{examSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int examSequence,
			@RequestParam(value="csatSequence",required=true) int csatSequence) {
		logger.info("data manage exam delete");
		examService.delete(csatSequence, examSequence);
	}
	
}
