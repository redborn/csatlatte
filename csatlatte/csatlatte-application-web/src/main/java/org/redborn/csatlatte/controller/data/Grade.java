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

/**
 * 내 성적 관리입니다.
 */
@Controller
@RequestMapping("/data/grade")
public class Grade {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GradeService gradeService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 성적 목록입니다.
	 * 
	 * @param model
	 * @param examSequence 시험 번호입니다.
	 */
	@RequestMapping(value="{examSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="examSequence") int examSequence) {
		logger.info("data grade list");
		model.addAttribute("list", gradeService.list(httpSessionValue.getCsatSequence(), examSequence, httpSessionValue.getStudentSequence()));
	}
	
	/**
	 * 성적 추가입니다.
	 * 
	 * @param model
	 * @param examSequence 시험 번호입니다.
	 * @param sectionSequence 영역번호입니다.
	 * @param subjectSequence 과목번호입니다.
	 * @param score 과목의 점수입니다.
	 */
	@RequestMapping(value="{examSequence}/{sectionSequence}/{subjectSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="examSequence") int examSequence, @PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence, @RequestParam(value="score",required=true) int score) {
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
	
	/**
	 * 성적 수정입니다.
	 * 
	 * @param model
	 * @param examSequence 시험 번호입니다.
	 * @param sectionSequence 영역번호입니다.
	 * @param subjectSequence 과목번호입니다.
	 * @param score 과목의 점수입니다.
	 */
	@RequestMapping(value="{examSequence}/{sectionSequence}/{subjectSequence}",method=RequestMethod.PUT)
	public void put(Model model, @PathVariable(value="examSequence") int examSequence, @PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence, @RequestParam(value="score",required=true) int score) {
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

	/**
	 * 성적 삭제입니다.
	 * 
	 * @param model
	 * @param examSequence 시험번호입니다.
	 * @param sectionSequence 영역번호입니다.
	 * @param subjectSequence 과목번호입니다.
	 */
	@RequestMapping(value="{examSequence}/{sectionSequence}/{subjectSequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable(value="examSequence") int examSequence, @PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence) {
		logger.info("data grade delete");
		model.addAttribute("result", gradeService.delete(httpSessionValue.getStudentSequence(), httpSessionValue.getCsatSequence(), examSequence, sectionSequence, subjectSequence));
	}
	
}