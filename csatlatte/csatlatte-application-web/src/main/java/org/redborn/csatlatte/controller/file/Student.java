package org.redborn.csatlatte.controller.file;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.spring.web.servlet.view.FileOutputStreamView;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/file/student")
public class Student {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	@RequestMapping(value="{studentSequence}",method=RequestMethod.GET)
	public View get(@PathVariable(value="studentSequence") int studentSequence) {
		logger.info(new StringBuilder("Controller student photo. studentSequence is ").append(studentSequence).append(".").toString());
		
		String photoName = studentService.getPhotoName(studentSequence);
		int beginIndex = photoName.lastIndexOf('.');
		String extension = null;
		if (beginIndex >= 0) {
			extension = photoName.substring(beginIndex);
		}

		return new FileOutputStreamView(studentService.getInputStream(studentSequence), extension, photoName);
	}
	
}
