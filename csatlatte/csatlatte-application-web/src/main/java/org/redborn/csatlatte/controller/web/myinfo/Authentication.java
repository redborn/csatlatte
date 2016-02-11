package org.redborn.csatlatte.controller.web.myinfo;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 아이디에 대한 보안을 위해 비밀번호를 인증하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/myinfo/authentication")
public class Authentication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 비밀번호를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("myinfo authentication view");
		return TilesName.MYINFO_AUTHENTICATION_WRITE;
	}
	
	/**
	 * 비밀번호 인증을 처리 합니다.
     * 
     * 인증을 성공하였을 경우 비밀번호 변경 처리 후 나의 정보로 페이지(redirect:/myinfo)로 이동합니다.
     * 
     * 인증을 실패하였을 경우 비밀번호 입력을 실패 페이지(TilesNane.MYINFO_AUTHENTICATION_FAIL)가 출력 됩니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="success",required=false,defaultValue="0") int success) {
		logger.info("myinfo authentication password wrote");
		String result = TilesName.MYINFO;
		if (success != 0) {
			result = TilesName.MYINFO_AUTHENTICATION_FAIL;
		}
		return result;
	}
}