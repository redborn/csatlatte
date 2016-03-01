package org.redborn.csatlatte.controller.file;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.spring.web.servlet.view.FileOutputStreamView;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

/**
 * 문의하기 파일첨부 기능에 대한 controller 영역입니다.
 */
@Controller
@RequestMapping("/file/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaService qnaService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 문의에 첨부한 파일을 조회하는 경로입니다.
	 * @param qnaSequence 첨부한 파일의 문의 번호입니다.
	 * @param fileSequence 파일의 번호입니다.
	 * @return
	 */
	@RequestMapping(value="{qnaSequence}/{fileSequence}",method=RequestMethod.GET)
	public View get(@PathVariable(value="qnaSequence") int qnaSequence, @PathVariable(value="fileSequence") int fileSequence) {
		logger.info(new StringBuilder("Controller file question. qnaSequence is ").append(qnaSequence).append(". fileSequence is ").append(fileSequence).append(".").toString());
		View view = null;
		if (qnaService.getWriter(qnaSequence) == httpSessionValue.getStudentSequence() || httpSessionValue.getRuleSequence() == HttpSessionValue.MANAGER) {
			String filename = qnaService.getFilename(qnaSequence, fileSequence);
			int beginIndex = filename.lastIndexOf('.');
			String extension = null;
			if (beginIndex >= 0) {
				extension = filename.substring(beginIndex);
			}
			view = new FileOutputStreamView(qnaService.getInputStream(qnaSequence, fileSequence), extension, filename);
		}
		return view;
	}

}