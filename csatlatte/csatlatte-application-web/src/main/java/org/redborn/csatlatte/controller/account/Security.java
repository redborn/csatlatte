package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 아이디, 비밀번호를 찾을 때 질문과 답변을 변경하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/{id}/security")
public class Security {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 보안질문을 선택하고 보안답변을 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("myinfo security view");
		model.addAttribute("securityQuestionList", studentService.securityQuestionList());
		return TilesName.PROFILE_SECURITY_WRITE;
	}

	/**
	 * 보안변경 처리 영역입니다.
	 * 
	 * 선택한 질문과 입력한 답변으로 변경 처리 후 보안변경 완료 페이지(TilesName.MYINFO_SECURITY_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="securityQuestionSequence",required=true) int securityQuestionSequence,
			@RequestParam(value="answer",required=true) String answer) {
		logger.info("myinfo security modify");
		String result = TilesName.PROFILE_SECURITY_FAIL;
		int studentSequence = httpSessionValue.getStudentSequence();
		StudentSecurityQuestionVo studentSecurityQuestionVo = new StudentSecurityQuestionVo();
		studentSecurityQuestionVo.setStudentSequence(studentSequence);
		studentSecurityQuestionVo.setSecurityQuestionSequence(securityQuestionSequence);
		studentSecurityQuestionVo.setContent(answer);
		
		if (studentService.changeSecurity(studentSecurityQuestionVo)) {
			result = TilesName.PROFILE_SECURITY_SUCCESS;
		}
		
		return result;
	}
}