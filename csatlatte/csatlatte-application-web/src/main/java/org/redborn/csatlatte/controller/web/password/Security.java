package org.redborn.csatlatte.controller.web.password;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 비밀번호를 찾을때 사용자 본인임을 확인하는 controller 입니다.  
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/password/security")
public class Security {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 비밀번호 찾기에 필요한 보안확인 인증을 처리합니다.
	 * 
	 * 입력한 답변이 찾으려는 아이디의 보안답변과 일치하는 경우 새 비밀번호 설정 페이지(TilesName.PASSWORD_NEW_WRITE)로 이동합니다.
	 * 
	 * 입력한 답변이 해당 아이디의 보안답변과 일치하지 않는 경우 비밀번호 찾기 보안확인 실패 페이지(TilesName.PASSWORD_SECURITY_FAIL)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="success",required=false,defaultValue="0") int success) {
		logger.info("find password new");
		String result = TilesName.PASSWORD_NEW_WRITE;
		if (success != 0) {
			result = TilesName.PASSWORD_SECURITY_FAIL;
		}
		return result;
	}
}
