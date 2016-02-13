package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.QnaVo;
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
 * 사용자가 문의한 목록을 조회하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/{id}/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 문의사항의 제목 목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("myinfo question list");
		int studentSequence = httpSessionValue.getStudentSequence();
		model.addAttribute("questionList", qnaService.listForStudent(studentSequence));
		return TilesName.PROFILE_QUESTION_LIST;
	}

	/**
	 * 문의 제목, 문의 내용, 문의에 대한 답변의 상세 내용을 조회하는 페이지(TilesName.MYINFO_QUESTION_DETAIL)입니다.
	 */
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.GET)
	public String detail(Model model, @PathVariable int qnaSequence) {
		logger.info("myinfo question detail");
		String result = TilesName.ERROR_404;
		int studentSequence = httpSessionValue.getStudentSequence();
		QnaVo qnaVo = qnaService.detailForStudent(studentSequence, qnaSequence);
		if (qnaVo != null) {
			if (!qnaVo.getContent().equals("")) {
				model.addAttribute("detail", qnaVo);
				result = TilesName.PROFILE_QUESTION_DETAIL;
			}
		}
		return result;
	}
	
	/**
	 * 사용자가 답변받지 않은 문의를 삭제하는 기능입니다.
	 */
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.DELETE)
	public String delete(Model model, @PathVariable int qnaSequence) {
		logger.info("profile question delete");
		String result = TilesName.ERROR_404;
		if (qnaService.delete(qnaSequence)) {
			int studentSequence = httpSessionValue.getStudentSequence();
			model.addAttribute("questionList", qnaService.listForStudent(studentSequence));
			result = TilesName.PROFILE_QUESTION_LIST;
		}
		return result;
	}
}