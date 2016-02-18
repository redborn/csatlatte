package org.redborn.csatlatte.controller.account;

import java.io.File;
import java.io.IOException;

import org.redborn.csatlatte.commons.io.FileDirectory;
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
import org.springframework.web.multipart.MultipartFile;

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
			@RequestParam(value="nickname",required=true) String nickname, @RequestParam(value="photo",required=false) MultipartFile photo) {
		logger.info("myinfo modify modify");
		String result = TilesName.PROFILE_MODIFY_FAIL;
		StudentVo studentVo = new StudentVo();
		studentVo.setStudentSequence(httpSessionValue.getRuleSequence());
		studentVo.setCsatSequence(csatSequence);
		studentVo.setNickname(nickname);
		File file = null;
		if (!photo.isEmpty()) {
			String originalFileName = photo.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.length() - 3, originalFileName.length());
			if (!(extension.equals("jpg") || extension.equals("png") || extension.equals("gif"))) {
				return result;
			}
			file = new File(new StringBuilder(FileDirectory.TEMP).append("/").append(originalFileName).toString());
			try {
				photo.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (studentService.changeInformation(studentVo, file)) {
			httpSessionValue.setUser(httpSessionValue.getId(), httpSessionValue.getStudentSequence(), nickname, httpSessionValue.getRuleSequence(), csatSequence);
			result = TilesName.PROFILE_MODIFY_SUCCESS;
		}
		return result;
	}

}