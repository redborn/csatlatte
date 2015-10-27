package org.redborn.csatlatte.controller.web.myinfo;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 비밀번호를 변경하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/myinfo/password")
public class Password {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 기존 비밀번호, 새 비밀번호를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("myinfo password view");
		return TilesName.MYINFO_PASSWORD_WRITE;
	}

	/**
	 * 비밀번호 변경 처리 영역입니다.
	 * 
	 * 입력한 값에 이상이 없는 경우 비밀번호 변경 처리 후 비밀번호 변경 완료 페이지(TilesName.MYINFO_PASSWORD_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="success",required=false,defaultValue="0") int success) {
		logger.info("myinfo password modify");
		String result = TilesName.MYINFO_PASSWORD_SUCCESS;
		return result;
	}

}