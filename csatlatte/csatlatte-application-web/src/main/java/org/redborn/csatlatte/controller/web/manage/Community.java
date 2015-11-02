package org.redborn.csatlatte.controller.web.manage;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 커뮤니티 게시글을 관리하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/manage/community")
public class Community {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 커뮤니티 게시글 목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("manage community view");
		return TilesName.MANAGE_COMMUNITY;
	}
}
