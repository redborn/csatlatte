package org.redborn.csatlatte.controller.data.community;

import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 커뮤니티 블라인드에 대한 data controller 영역입니다.
 */
@Controller
@RequestMapping("/data/community/blind")
public class Blind {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	/**
	 * 커뮤니티 글을 블라인드하는 method입니다.
	 * @param model
	 * @param communitySequence 블라인드 대상의 커뮤니티 글 번호입니다.
	 * @param blindTypeSequence 블라인드 사유 번호입니다.
	 */
	@RequestMapping(value="{communitySequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="communitySequence") int communitySequence, @RequestParam(value="blindTypeSequence",required=true) int blindTypeSequence) {
		logger.info(new StringBuilder("data community blind... communitySequence is ").append(communitySequence).toString());
		model.addAttribute("result", communityService.blind(CommunityService.COMMUNITY, communitySequence, blindTypeSequence));
	}

}