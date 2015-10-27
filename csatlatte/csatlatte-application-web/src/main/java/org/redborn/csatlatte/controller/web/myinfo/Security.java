package org.redborn.csatlatte.controller.web.myinfo;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 아이디, 비밀번호를 찾을 때 질문과 답변을 변경하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/myinfo/security")
public class Security {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 보안질문을 선택하고 보안답변을 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("myinfo security view");
		return TilesName.MYINFO_SECURITY_WRITE;
	}

	/**
	 * 보안변경 처리 영역입니다.
	 * 
	 * 선택한 질문과 입력한 답변으로 변경 처리 후 보안변경 완료 페이지(TilesName.MYINFO_SECURITY_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="success",required=false,defaultValue="0") int success) {
		logger.info("myinfo security modify");
		String result = TilesName.MYINFO_SECURITY_SUCCESS;
		return result;
	}
	
}