package org.redborn.csatlatte.controller.data.student;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자 계정 블라인드입니다.
 */
@Controller
@RequestMapping("/data/student/lock")
public class Lock {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 사용자 계정 블라인드입니다.
	 * 
	 * @param model
	 * @param studentSequence 사용자 번호입니다.
	 */
	@RequestMapping(value="{studentSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="studentSequence") int studentSequence) {
		logger.info("data student update to useYn = 'N'");
		
		model.addAttribute("result", studentService.lock(studentSequence));
	}
	
	/**
	 * 사용자 계정 블라인드 해제입니다.
	 * 
	 * @param model
	 * @param studentSequence 사용자 번호입니다.
	 */
	@RequestMapping(value="{studentSequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable int studentSequence) {
		logger.info("data student update to useYn = 'Y'");
		
		model.addAttribute("result", studentService.unlock(studentSequence));
	}

}
