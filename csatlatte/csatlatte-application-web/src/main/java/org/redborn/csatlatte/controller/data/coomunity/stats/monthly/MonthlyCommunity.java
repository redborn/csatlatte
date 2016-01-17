package org.redborn.csatlatte.controller.data.coomunity.stats.monthly;

import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/community/stats/monthly")
public class MonthlyCommunity {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="ym",required=true) String ym) {
		logger.info("data stats monthlycommunity view");
	
		model.addAttribute("monthlyActive", communityService.monthlyActive(CommunityService.COMMUNITY, ym));
	}
}
