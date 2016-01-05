package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자간의 소통을 하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/community")
public class Community {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;

	/**
	 * 사용자 본인과 다른 사용자가 작성한 글, 댓글을 조회 및 새로운 글, 댓글을 작성, 수정하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("community view");
		model.addAttribute("reportTypeList", communityService.reportTypeList());
		if (httpSessionValue.getRuleSequence() == HttpSessionValue.MANAGER) {
			model.addAttribute("blindTypeList", communityService.blindTypeList());
		}
		model.addAttribute("nav", 0);
		return TilesName.COMMUNITY;
	}	
}