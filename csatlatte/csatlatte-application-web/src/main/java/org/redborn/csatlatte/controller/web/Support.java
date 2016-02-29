package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.FaqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 사용자가 서비스 이용 중 문제가 발생했을 때 이용하는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/support")
public class Support {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FaqService faqService;
	/**
	 * FAQ(자주 묻는 질문) 조회 페이지 입니다.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model, @RequestParam(value="faqTypeSequence",required=false,defaultValue="1") int faqTypeSequence) {
		logger.info("support view");
		model.addAttribute("list", faqService.list(faqTypeSequence));
		return TilesName.SUPPORT;
	}

}