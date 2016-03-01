package org.redborn.csatlatte.controller.data;

import java.io.IOException;
import java.util.List;

import org.redborn.csatlatte.commons.poi.RatingCutReader;
import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.service.ExamService;
import org.redborn.csatlatte.service.RatingCutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 모의고사 등급컷입니다.
 */
@Controller
@RequestMapping("/data/rating")
public class Rating {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private RatingCutService ratingCutService;
	
	/**
	 * 등급컷 목록입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 */
	@RequestMapping(value="{csatSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence) {
		logger.info("data manage rating get view");
		model.addAttribute("list",examService.listForRatingManage(csatSequence));
		model.addAttribute("listForCreate",examService.listForRatingCreate(csatSequence));
	}
	
	/**
	 * 등급컷 상세내용 조회입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET)
	public void detail(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage rating detail view");
		
		model.addAttribute("list", ratingCutService.list(csatSequence, examSequence));
	}
	
	/**
	 * 등급컷 추가입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param file 등급컷 파일
	 * @throws IOException
	 */
	@RequestMapping(value="{csatSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@RequestParam(value="examSequence",required=true) int examSequence,
			@RequestParam(value="file",required=true) MultipartFile file) throws IOException {
		logger.info("data rating post");
		if (file != null) {
			RatingCutReader ratingCutReader = new RatingCutReader(file.getInputStream(), csatSequence, examSequence);
			List<SectionVo> sectionList = ratingCutReader.sectionList();
			List<SubjectVo> subjectList = ratingCutReader.subjectList();
			List<RatingCutVo> ratingCutList = ratingCutReader.ratingCutList();
			List<AverageVo> averageList = ratingCutReader.averageList();
			if (sectionList != null && subjectList != null && ratingCutList != null && averageList != null) {
				model.addAttribute("result", ratingCutService.register(sectionList, subjectList, ratingCutList, averageList));
				logger.info("success register ratingcut");
			}
		}
	}
	
	/**
	 * 등급컷 수정입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param file 등급컷 파일
	 * @throws IOException
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.PUT)
	public void put(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence,
			@RequestParam(value="file",required=false) MultipartFile file) throws IOException {
		logger.info("data rating put");
		if (file != null) {
			RatingCutReader ratingCutReader = new RatingCutReader(file.getInputStream(), csatSequence, examSequence);
			ratingCutService.delete(csatSequence, examSequence);
			List<SectionVo> sectionList = ratingCutReader.sectionList();
			List<SubjectVo> subjectList = ratingCutReader.subjectList();
			List<RatingCutVo> ratingCutList = ratingCutReader.ratingCutList();
			List<AverageVo> averageList = ratingCutReader.averageList();
			if (sectionList != null && subjectList != null && ratingCutList != null && averageList != null) {
				model.addAttribute("result", ratingCutService.register(sectionList, subjectList, ratingCutList, averageList));
				logger.info("success register ratingcut");
			}
		}
	}
	
	/**
	 * 등급컷 삭제입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable(value="csatSequence") int csatSequence, 
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data manage rating delete");
		model.addAttribute("result", ratingCutService.delete(csatSequence, examSequence));
	}
	
}
