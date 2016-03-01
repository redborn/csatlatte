package org.redborn.csatlatte.controller.data;

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

/**
 * 모의고사입니다.
 */
@Controller
@RequestMapping("/data/exam")
public class Exam {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private StudentService studentService;
	
	/**
	 * 모의고사 목록입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 번호입니다.
	 */
	@RequestMapping(value="{csatSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence) {
		logger.info("data manage exam get view");
		
		model.addAttribute("list", examService.listForManage(csatSequence));
	}
	
	/**
	 * 모의고사 상세정보입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 번호입니다.
	 * @param examSequence 모의고사 번호입니다.
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET) 
	public void detail(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage exam detail view");

		model.addAttribute("detail", examService.detail(csatSequence, examSequence));
	}
	
	/**
	 * 모의고사 추가입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 번호입니다.
	 * @param examName 모의고사의 이름입니다.
	 * @param institutionSequence 주관 교육청 번호입니다.
	 * @param yearStudentSequence 학년 번호입니다.
	 * @param ymd 모의고사가 실시된 날짜입니다.
	 */
	@RequestMapping(value="{csatSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@RequestParam(value="examName",required=true) String examName,
			@RequestParam(value="institutionSequence",required=true) int institutionSequence,
			@RequestParam(value="yearStudentSequence",required=true) int yearStudentSequence,
			@RequestParam(value="ymd",required=true) String ymd) {
		logger.info("data exam post view");
		ExamVo examVo = new ExamVo();
		
		examVo.setCsatSequence(csatSequence);
		examVo.setExamName(examName);
		examVo.setInstitutionSequence(institutionSequence);
		examVo.setYearStudentSequence(yearStudentSequence);
		examVo.setYmd(ymd);
		
		model.addAttribute("result", examService.register(examVo));
	}
	
	/**
	 * 모의고사 수정입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 번호입니다.
	 * @param examSequence 시험의 번호입니다.
	 * @param examName 시험 이름입니다.
	 * @param institutionSequence 주관 교육청 번호입니다. 
	 * @param yearStudentSequence 학년 번호입니다.
	 * @param ymd 시험이 실시된 날짜입니다.
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.PUT)
	public void put(Model model, @PathVariable(value="csatSequence") int csatSequence, 
			@PathVariable(value="examSequence") int examSequence,
			@RequestParam(value="examName",required=true) String examName,
			@RequestParam(value="institutionSequence",required=true) int institutionSequence,
			@RequestParam(value="yearStudentSequence",required=true) int yearStudentSequence,
			@RequestParam(value="ymd",required=true) String ymd) {
		logger.info("data manage exam put view");
		
		ExamVo examVo = new ExamVo();
		
		examVo.setExamSequence(examSequence);
		examVo.setCsatSequence(csatSequence);
		examVo.setExamName(examName);
		examVo.setInstitutionSequence(institutionSequence);
		examVo.setYearStudentSequence(yearStudentSequence);
		examVo.setYmd(ymd);
		
		model.addAttribute("result", examService.modify(examVo));
	}
	
	/**
	 * 모의고사 삭제입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 번호입니다.
	 * @param examSequence 시험의 번호입니다.
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage exam delete");
		model.addAttribute("result", examService.delete(csatSequence, examSequence));
	}
}
