package org.redborn.csatlatte.controller.data.community.stats;

import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 월간 커뮤니티 통계입니다.
 */
@Controller
@RequestMapping("/data/community/stats/monthly")
public class Monthly {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	/**
	 * 월간 커뮤니티 통계입니다.
	 * 
	 * @param model
	 * @param ym 연월
	 */
	@RequestMapping(value="{ym}", method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="ym") String ym) {
		logger.info("Controller data community stats monthly GET.");
	
		model.addAttribute("monthlyActive", communityService.monthlyActive(CommunityService.COMMUNITY, ym));
	}
}
