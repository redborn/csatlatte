package org.redborn.csatlatte.controller.account;

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
 * 내가 작성한 커뮤니티 글에 대한 controller입니다.
 */
@Controller
@RequestMapping("/{id}/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 내가 작성한 커뮤니티 글만 나타나는 커뮤니티 페이지(TilesName.COMMUNITY)로 이동합니다.
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("community view");
		model.addAttribute("reportTypeList", communityService.reportTypeList());
		if (httpSessionValue.getRuleSequence() == HttpSessionValue.MANAGER) {
			model.addAttribute("blindTypeList", communityService.blindTypeList());
		}
		model.addAttribute("nav", 1);
		return TilesName.COMMUNITY;
	}
	
}
