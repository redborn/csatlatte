package org.redborn.csatlatte.commons.poi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

/**
 * 등급 컷 excel 파일 reader 입니다.
 * 
 * @author 최순열
 *
 */
public class RatingCutReader {
	
	private XSSFWorkbook workbook;
	private int csatSequence;
	private int examSequence;
	private List<SectionVo> sectionVos;
	private List<SubjectVo> subjectVos;
	private List<RatingCutVo> ratingCutVos;
	private List<AverageVo> averageVos;
	
	public RatingCutReader(InputStream inputStream, int csatSequence, int examSequence) throws IOException {
		workbook = new XSSFWorkbook(inputStream);
		this.csatSequence = csatSequence;
		this.examSequence = examSequence;
		init();
	}
	
	public void init() {
		parseSectionList();
		parseRatingCutList();
		parseSubjectListAndAverageList();
	}
	
	private void parseSectionList() {
		XSSFSheet sectionSheet = workbook.getSheet("section");
		if (sectionSheet != null) {
			sectionVos = new ArrayList<SectionVo>();
			SectionVo sectionVo;
			XSSFRow csatExamSectionRow;
			int physicalNumberOfRows = sectionSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				csatExamSectionRow = sectionSheet.getRow(rowIndex);
				sectionVo = new SectionVo();
				sectionVo.setCsatSequence(csatSequence);
				sectionVo.setExamSequence(examSequence);
				sectionVo.setSectionSequence((int) csatExamSectionRow.getCell(0).getNumericCellValue());
				sectionVo.setSectionName(csatExamSectionRow.getCell(1).getStringCellValue());
				sectionVo.setSelectCount((int) csatExamSectionRow.getCell(2).getNumericCellValue());
				sectionVos.add(sectionVo);
			}
		}
	}
	
	private void parseSubjectListAndAverageList() {
		XSSFSheet subjectAndAverageSheet = workbook.getSheet("subject&average");
		if (subjectAndAverageSheet != null) {
			subjectVos = new ArrayList<SubjectVo>();
			averageVos = new ArrayList<AverageVo>();
			SubjectVo subjectVo;
			AverageVo averageVo;
			XSSFRow subjectAndRatingCutRow;
			int physicalNumberOfRows = subjectAndAverageSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				subjectAndRatingCutRow = subjectAndAverageSheet.getRow(rowIndex);
				subjectVo = new SubjectVo();
				subjectVo.setCsatSequence(csatSequence);
				subjectVo.setExamSequence(examSequence);
				subjectVo.setSectionSequence((int) subjectAndRatingCutRow.getCell(0).getNumericCellValue());
				subjectVo.setSubjectSequence((int) subjectAndRatingCutRow.getCell(1).getNumericCellValue());
				subjectVo.setSubjectName(subjectAndRatingCutRow.getCell(2).getStringCellValue());
				subjectVo.setMaxScore((int) subjectAndRatingCutRow.getCell(3).getNumericCellValue());
				subjectVo.setExamTime((int) subjectAndRatingCutRow.getCell(6).getNumericCellValue());
				subjectVos.add(subjectVo);

				averageVo = new AverageVo();
				averageVo.setCsatSequence(csatSequence);
				averageVo.setExamSequence(examSequence);
				averageVo.setSectionSequence((int) subjectAndRatingCutRow.getCell(0).getNumericCellValue());
				averageVo.setSubjectSequence((int) subjectAndRatingCutRow.getCell(1).getNumericCellValue());
				averageVo.setAverage((float) subjectAndRatingCutRow.getCell(4).getNumericCellValue());
				averageVo.setStandardDeviation((float) subjectAndRatingCutRow.getCell(5).getNumericCellValue());
				averageVos.add(averageVo);
				
				
			}
		}
	}
	
	private void parseRatingCutList() {
		XSSFSheet ratingCutSheet = workbook.getSheet("ratingcut");
		if (ratingCutSheet != null) {
			ratingCutVos = new ArrayList<RatingCutVo>();
			RatingCutVo ratingCutVo;
			XSSFRow csatExamRatingCutRow;
			int physicalNumberOfRows = ratingCutSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				csatExamRatingCutRow = ratingCutSheet.getRow(rowIndex);
				ratingCutVo = new RatingCutVo();
				ratingCutVo.setCsatSequence(csatSequence);
				ratingCutVo.setRatingCode((int) csatExamRatingCutRow.getCell(0).getNumericCellValue());
				ratingCutVo.setExamSequence(examSequence);
				ratingCutVo.setSectionSequence((int) csatExamRatingCutRow.getCell(1).getNumericCellValue());  
				ratingCutVo.setSubjectSequence((int) csatExamRatingCutRow.getCell(2).getNumericCellValue());
				ratingCutVo.setRawScore((int) csatExamRatingCutRow.getCell(3).getNumericCellValue());
				ratingCutVo.setStandardScore((int) csatExamRatingCutRow.getCell(4).getNumericCellValue());
				ratingCutVos.add(ratingCutVo);
			}
		}
	}
	
	/**
	 * 영역 리스트 입니다.
	 * 
	 * @return 영역 리스트
	 */
	public List<SectionVo> sectionList() {
		return sectionVos;
	}
	
	/**
	 * 과목 리스트 입니다.
	 * 
	 * @return 과목 리스트
	 */
	public List<SubjectVo> subjectList() {
		return subjectVos;
	}
	
	/**
	 * 등급 컷 리스트 입니다.
	 * 
	 * @return 등급 컷 리스트
	 */
	public List<RatingCutVo> ratingCutList() {
		return ratingCutVos;
	}
	
	/**
	 * 평균 리스트 입니다.
	 * 
	 * @return 평균 리스트
	 */
	public List<AverageVo> averageList() {
		return averageVos;
	}

}