package org.redborn.csatlatte.controller.web.myinfo;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 사용자 정보를 수정하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/myinfo/modify")
public class Modify {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 닉네임 입력, 프로필 사진 등록, 수능을 선택하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("myinfo modify view");
		return TilesName.MYINFO_MODIFY_WRITE;
	}

	/**
	 * 내 정보 변경 처리 영역입니다. 
	 * 
	 * 변경한 프로필 사진, 닉네임, 수능을 변경 처리 후 내 정보 변경 완료 페이지(TilesName.MYINFO_MODIFY_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="success",required=false,defaultValue="0") int success) {
		logger.info("myinfo modify modify");
		String result = TilesName.MYINFO_MODIFY_SUCCESS;
		return result;
	}

}