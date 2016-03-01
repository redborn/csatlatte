package org.redborn.csatlatte.controller.data.community;

import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.CommentVo;
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
 * 커뮤니티 댓글입니다.
 */
@Controller
@RequestMapping("/data/community/comment")
public class Comment {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	/**
	 * 커뮤니티 댓글 목록입니다.
	 * 
	 * @param model
	 * @param communitySequence 커뮤니티 일련번호
	 */
	@RequestMapping(value="{communitySequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="communitySequence") int communitySequence) {
		logger.info(new StringBuilder("data community comment list... community is ").append(communitySequence).toString());
		model.addAttribute("list", communityService.commentList(CommunityService.COMMUNITY, communitySequence, httpSessionValue.getStudentSequence()));
	}
	
	/**
	 * 커뮤니티 댓글 추가입니다.
	 * 
	 * @param model
	 * @param communitySequence 커뮤니티 일련번호
	 * @param content 내용
	 */
	@RequestMapping(value="{communitySequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="communitySequence") int communitySequence, @RequestParam(value="content",required=true) String content) {
		logger.info(new StringBuilder("data community comment write... community is ").append(communitySequence).toString());
		CommentVo commentVo = new CommentVo();
		commentVo.setCommunityTypeSequence(CommunityService.COMMUNITY);
		commentVo.setCommunitySequence(communitySequence);
		commentVo.setStudentSequence(httpSessionValue.getStudentSequence());
		commentVo.setContent(content);
		model.addAttribute("result", communityService.writeComment(commentVo, httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp()));
	}
	
	/**
	 * 커뮤니티 댓글 삭제입니다.
	 * 
	 * @param model
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 */
	@RequestMapping(value="{communitySequence}/{commentSequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable(value="communitySequence") int communitySequence, @PathVariable(value="commentSequence") int commentSequence) {
		logger.info(new StringBuilder("data community comment delete... community is ").append(communitySequence).append("... and comment is ").append(commentSequence).toString());
		model.addAttribute("result", communityService.deleteComment(CommunityService.COMMUNITY, communitySequence, commentSequence, httpSessionValue.getStudentSequence()));
	}

}