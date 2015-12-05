package org.redborn.csatlatte.controller.web.support;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.QnaVo;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FAQ(자주 묻는 질문)에서 해결되지 않은 궁금사항, 혹은 건의사항 작성에 대한 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/support/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	/**
	 * 문의 제목, 내용을 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("support question view");
		return TilesName.SUPPORT_QUESTION_WRITE;
	}

	/**
	 * SUPPORT_QUESTION_SUCCESS : 문의 작성 완료
	 * --> 문의제목, 문의내용을 처리하는 영역입니다.
	 * 
	 * 처리 결과
	 * SUPPORT_QUESTION_SUCCESS : 문의하기 완료
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="title",required=true) String title, @RequestParam(value="content", required=true) String content) {
		QnaVo qnaVo = new QnaVo();
		qnaVo.setTitle(title);
		qnaVo.setContent(content);
		qnaVo.setStudentSequence(httpSessionValue.getStudentSequence());
		logger.info("support question write");
		qnaService.write(qnaVo, null);
		return TilesName.SUPPORT_QUESTION_SUCCESS;
	}
}