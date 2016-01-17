package org.redborn.csatlatte.controller.data.coomunity.stats.daily;

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
@RequestMapping("/data/community/stats/daily")
public class DailyCommunity {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="ymd",required=true) String ymd) {
		logger.info("data stats dailycommunity view");
		
		model.addAttribute("dailyActive", communityService.dailyActive(CommunityService.COMMUNITY, ymd));
	}
}
