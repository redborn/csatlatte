package org.redborn.csatlatte.controller.data.manage;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data/manage/student")
public class Student {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="{studentSequence}",method=RequestMethod.POST)
	public void post(@PathVariable(value="studentSequence") int studentSequence) {
		logger.info("data student update to useYn = 'Y'");
		
		studentService.recovery(studentSequence);
	}
	
	@RequestMapping(value="{studentSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int studentSequence) {
		logger.info("data student update to useYn = 'N'");
		
		studentService.lock(studentSequence);
	}

}
