package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.service.ExamService;
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
 * 사용자 정보를 수정하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/{id}/modify")
public class Modify {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private StudentService studentService;

	/**
	 * 닉네임 입력, 프로필 사진 등록, 수능을 선택하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("myinfo modify view");
		model.addAttribute("studentCsat", httpSessionValue.getCsatSequence());
		model.addAttribute("csatList", examService.csatList());
		return TilesName.PROFILE_MODIFY_WRITE;
	}

	/**
	 * 내 정보 변경 처리 영역입니다. 
	 * 
	 * 변경한 프로필 사진, 닉네임, 수능을 변경 처리 후 내 정보 변경 완료 페이지(TilesName.MYINFO_MODIFY_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="csatSequence",required=true) int csatSequence,
			@RequestParam(value="nickname",required=true) String nickname) {
		logger.info("myinfo modify modify");
		String result = TilesName.PROFILE_MODIFY_FAIL;
		StudentVo studentVo = new StudentVo();
		int studentSequence = httpSessionValue.getStudentSequence();
		int ruleSequence = httpSessionValue.getRuleSequence();
		String id = httpSessionValue.getId();
		studentVo.setStudentSequence(studentSequence);
		studentVo.setCsatSequence(csatSequence);
		studentVo.setNickname(nickname);
		studentVo.setPhotoCode("MODIFY-TEST");
		studentVo.setPhotoName("MODIFY-TEST");
		httpSessionValue.setUser(id, studentSequence, nickname, ruleSequence, csatSequence);
		if (studentService.changeInformation(studentVo)) {
			result = TilesName.PROFILE_MODIFY_SUCCESS;
		}
		return result;
	}

}