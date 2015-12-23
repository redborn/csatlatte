package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 커뮤니티 controller 입니다.
 * 
 * @author 최순열
 *
 */
@Controller
@RequestMapping("/data/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model) {
		logger.info("data community list");
		model.addAttribute("list", communityService.list(CommunityService.COMMUNITY));
	}
	
}