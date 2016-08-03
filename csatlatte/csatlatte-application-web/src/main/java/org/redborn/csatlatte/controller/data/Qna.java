package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 문의입니다.
 */
@Controller
@RequestMapping("/data/qna")
public class Qna {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
    private HttpSessionValue httpSessionValue;
	
	/**
	 * 문의 상세내용을 조회합니다.
	 * 
	 * @param model
	 * @param qnaSequence 문의 일련번호
	 */
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="qnaSequence") int qnaSequence) {
		logger.info("Controller data qna GET.");
		model.addAttribute("detail", qnaService.detail(qnaSequence));
		model.addAttribute("files", qnaService.fileList(qnaSequence));
	}
	
}
