package org.redborn.csatlatte.controller.file.exam;

import org.redborn.csatlatte.commons.spring.web.servlet.view.FileOutputStreamView;
import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

/**
 * 문제 이미지 파일입니다.
 */
@Controller
@RequestMapping("/file/exam/objectitem")
public class ObjectItem {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{csatSequence}/{examSequence}/{sectionSequence}/{subjectSequence}/{questionSequence}/{objectItemSequence}/{imageSequence}",method=RequestMethod.GET)
	public View get(@PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence,
			@PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence,
			@PathVariable(value="questionSequence") int questionSequence, @PathVariable(value="objectItemSequence") int objectItemSequence, @PathVariable(value="imageSequence") int imageSequence) {
		logger.info("Controller file Question GET.");
		View view = null;
		if (examService.checkObjectItemImageFile(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence, objectItemSequence, imageSequence)) {
			String fileName =  examService.getObjectItemImageFileName(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence, objectItemSequence, imageSequence);
			String extension = null;
			int beginIndex = fileName.lastIndexOf('.');
			if (beginIndex >= 0) {
				extension = fileName.substring(beginIndex + 1);
			}
			view = new FileOutputStreamView(examService.getObjectItemImageInputStream(csatSequence, examSequence, sectionSequence, subjectSequence, questionSequence, objectItemSequence, imageSequence), extension, fileName);
		}
		return view;
	}
		
}