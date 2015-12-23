package org.redborn.csatlatte.controller.data.community;

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
@RequestMapping("/data/community/comment")
public class Comment {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="communitySequence",required=true) int communitySequence) {
		logger.info(new StringBuilder("data community comment list... comment is ").append(communitySequence).toString());
		model.addAttribute("list", communityService.commentList(CommunityService.COMMUNITY, communitySequence));
	}

}