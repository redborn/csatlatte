package org.redborn.csatlatte.controller.web.manage;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자 정보를 조회하고 관리자 권한, 계정에 대한 차단 등을 설정하는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/manage/user")
public class User {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 사용자 정보를 관리하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("manage user view");
		return TilesName.MANAGE_USER;
	}
}
