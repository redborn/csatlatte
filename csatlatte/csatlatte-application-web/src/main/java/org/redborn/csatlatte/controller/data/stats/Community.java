package org.redborn.csatlatte.controller.data.stats;

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
@RequestMapping("/data/stats/community")
public class Community {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="date",required=true) String date,
			@RequestParam(value="item",required=true) int item) {
		logger.info("data stats community view");
		
		switch(item) {
		case 1:
			model.addAttribute("dailyActive", communityService.dailyActive(CommunityService.COMMUNITY, date));
			break;
		case 2:
			model.addAttribute("monthlyActive", communityService.monthlyActive(CommunityService.COMMUNITY, date));
			break;
		case 3:
			model.addAttribute("annualActive", communityService.annualActive(CommunityService.COMMUNITY, date));
			break;
		}
	}
	
}
