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
 * 지문 이미지 파일입니다.
 */
@Controller
@RequestMapping("/file/exam/text")
public class Text {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{csatSequence}/{examSequence}/{sectionSequence}/{subjectSequence}/{textSequence}/{imageSequence}",method=RequestMethod.GET)
	public View get(@PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence,
			@PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence,
			@PathVariable(value="textSequence") int textSequence, @PathVariable(value="imageSequence") int imageSequence) {
		logger.info("Controller file Text GET.");
		View view = null;
		if (examService.isTextImageFile(csatSequence, examSequence, sectionSequence, subjectSequence, textSequence, imageSequence)) {
			String fileName =  examService.getTextImageFileName(csatSequence, examSequence, sectionSequence, subjectSequence, textSequence, imageSequence);
			String extension = null;
			int beginIndex = fileName.lastIndexOf('.');
			if (beginIndex >= 0) {
				extension = fileName.substring(beginIndex + 1);
			}
			view = new FileOutputStreamView(examService.getTextImageInputStream(csatSequence, examSequence, sectionSequence, subjectSequence, textSequence, imageSequence), extension, fileName);
		}
		return view;
	}
		
}