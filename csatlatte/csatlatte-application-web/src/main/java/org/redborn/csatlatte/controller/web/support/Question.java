package org.redborn.csatlatte.controller.web.support;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.redborn.csatlatte.commons.io.FileDirectory;
import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.QnaVo;
import org.redborn.csatlatte.service.QnaService;
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
 * FAQ(자주 묻는 질문)에서 해결되지 않은 궁금사항, 혹은 건의사항 작성에 대한 controller입니다.
 */
@Controller
@RequestMapping("/support/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
    private HttpSessionValue httpSessionValue;
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	/**
	 * 문의 제목, 내용을 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("support question view");
		return TilesName.SUPPORT_QUESTION_WRITE;
	}

	/**
	 * 문의제목, 문의내용을 처리하는 영역입니다.
	 * 
	 * 처리가 성공적으로 완료된 경우 완료 페이지(TilesName.SUPPORT_QUESTION_SUCCESS)로 이동합니다.
	 * 
	 * 처리 과정 중 문제가 발생하거나 실패한 경우 실패 페이지(TilesName.SUPPORT_QUESTION_FAIL)로 이동합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="title",required=true) String title, @RequestParam(value="content", required=true) String content,
			@RequestParam(value="file",required=false) List<MultipartFile> file) {
		logger.info("support question write");
		String result = TilesName.SUPPORT_QUESTION_FAIL;
		QnaVo qnaVo = new QnaVo();
		qnaVo.setTitle(title);
		qnaVo.setContent(content);
		qnaVo.setStudentSequence(httpSessionValue.getStudentSequence());
		
		List<File> files = new ArrayList<File>(); 
		if (file != null) {
			int fileSize = file.size();
			for (int index = 0; index < fileSize; index++) {
				if (!file.get(index).isEmpty()) {
					MultipartFile addMultipartFile = file.get(index);
					File addFile = new File(new StringBuilder(FileDirectory.TEMP).append("/").append(addMultipartFile.getOriginalFilename()).toString());
					try {
						addMultipartFile.transferTo(addFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					files.add(index, addFile);
				}
			}
		}
		if (qnaService.write(qnaVo, files, httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp())) {
			result = TilesName.SUPPORT_QUESTION_SUCCESS;
		}
		return result;
	}
}