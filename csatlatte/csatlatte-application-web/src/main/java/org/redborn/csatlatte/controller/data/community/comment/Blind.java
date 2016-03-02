package org.redborn.csatlatte.controller.data.community.comment;

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
 * 커뮤니티 댓글 블라인드입니다.
 */
@Controller
@RequestMapping("/data/community/comment/blind")
public class Blind {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	/**
	 * 커뮤니티 댓글 블라인드입니다.
	 * 
	 * @param model
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param blindTypeSequence 블라인드 일련번호
	 */
	@RequestMapping(value="{communitySequence}/{commentSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="communitySequence") int communitySequence, @PathVariable(value="commentSequence") int commentSequence, @RequestParam(value="blindTypeSequence",required=true) int blindTypeSequence) {
		logger.info(new StringBuilder("Controller data community comment blind... communitySequence is ").append(communitySequence).append(" commentSequence is ").append(commentSequence).toString());
		model.addAttribute("result", communityService.blindComment(CommunityService.COMMUNITY, communitySequence, commentSequence, blindTypeSequence));
	}

}
