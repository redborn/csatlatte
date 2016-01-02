package org.redborn.csatlatte.controller.data.manage;

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
@RequestMapping("/data/manage/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="communitySequence",required=true) int communitySequence) {
		logger.info("data manage community view");
		
		model.addAttribute("detail", communityService.detail(CommunityService.COMMUNITY, communitySequence));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void post(@RequestParam(value="communityTypeSequence",required=true,defaultValue="1") int communityTypeSequence, 
			@RequestParam(value="communitySequence",required=true) int communitySequence) {
		logger.info("data manage community insert blind");
		
		communityService.blind(communityTypeSequence, communitySequence, "관리자에 의한 블라인드");
	}
}
