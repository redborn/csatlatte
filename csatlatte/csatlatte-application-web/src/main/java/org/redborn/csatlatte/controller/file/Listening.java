package org.redborn.csatlatte.controller.file;

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
 * 듣기 평가 파일입니다.
 */
@Controller
@RequestMapping("/file/listening")
public class Listening {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{csatSequence}/{examSequence}/{sectionSequence}/{subjectSequence}",method=RequestMethod.GET)
	public View get(@PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence,
			@PathVariable(value="sectionSequence") int sectionSequence, @PathVariable(value="subjectSequence") int subjectSequence) {
		logger.info("Controller file Listening GET.");
		View view = null;
		if (examService.isListeningFile(csatSequence, examSequence, sectionSequence, subjectSequence)) {
			String fileName =  examService.getFileName(csatSequence, examSequence, sectionSequence, subjectSequence);
			String extension = null;
			int beginIndex = fileName.lastIndexOf('.');
			if (beginIndex >= 0) {
				extension = fileName.substring(beginIndex + 1);
			}
			view = new FileOutputStreamView(examService.getInputStream(csatSequence, examSequence, sectionSequence, subjectSequence), extension, fileName);
		}
		return view;
	}
		
}
