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
	
	public RatingCutReader(InputStream inputStream) throws IOException {
		workbook = new XSSFWorkbook(inputStream);
	}
	
	/**
	 * 영역 리스트 입니다.
	 * 
	 * @return 영역 리스트
	 */
	public List<SectionVo> sectionList() {
		List<SectionVo> sectionVos = null;
		XSSFSheet csatExamSectionSheet = workbook.getSheet("csat_exam_section");
		if (csatExamSectionSheet != null) {
			sectionVos = new ArrayList<SectionVo>();
			SectionVo sectionVo;
			XSSFRow csatExamSectionRow;
			int physicalNumberOfRows = csatExamSectionSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				csatExamSectionRow = csatExamSectionSheet.getRow(rowIndex);
				sectionVo = new SectionVo();
				sectionVo.setCsatSequence((int) csatExamSectionRow.getCell(0).getNumericCellValue());
				sectionVo.setExamSequence((int) csatExamSectionRow.getCell(1).getNumericCellValue());
				sectionVo.setSectionSequence((int) csatExamSectionRow.getCell(2).getNumericCellValue());
				sectionVo.setSectionName(csatExamSectionRow.getCell(3).getStringCellValue());
				sectionVo.setSelectCount((int) csatExamSectionRow.getCell(4).getNumericCellValue());
				sectionVos.add(sectionVo);
			}
		}
		return sectionVos;
	}
	
	/**
	 * 과목 리스트 입니다.
	 * 
	 * @return 과목 리스트
	 */
	public List<SubjectVo> subjectList() {
		List<SubjectVo> subjectVos = null;
		XSSFSheet csatExamSubjectSheet = workbook.getSheet("csat_exam_subject");
		if (csatExamSubjectSheet != null) {
			subjectVos = new ArrayList<SubjectVo>();
			SubjectVo subjectVo;
			XSSFRow csatExamSubjectRow;
			int physicalNumberOfRows = csatExamSubjectSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				csatExamSubjectRow = csatExamSubjectSheet.getRow(rowIndex);
				subjectVo = new SubjectVo();
				subjectVo.setCsatSequence((int) csatExamSubjectRow.getCell(0).getNumericCellValue());
				subjectVo.setExamSequence((int) csatExamSubjectRow.getCell(1).getNumericCellValue());
				subjectVo.setSectionSequence((int) csatExamSubjectRow.getCell(2).getNumericCellValue());
				subjectVo.setSubjectSequence((int) csatExamSubjectRow.getCell(3).getNumericCellValue());
				subjectVo.setSubjectName(csatExamSubjectRow.getCell(4).getStringCellValue());
				subjectVo.setMaxScore((int) csatExamSubjectRow.getCell(5).getNumericCellValue());
				subjectVos.add(subjectVo);
			}
		}
		return subjectVos;
	}
	
	/**
	 * 등급 컷 리스트 입니다.
	 * 
	 * @return 등급 컷 리스트
	 */
	public List<RatingCutVo> ratingCutList() {
		List<RatingCutVo> ratingCutVos = null;
		XSSFSheet csatExamRatingCutSheet = workbook.getSheet("csat_exam_rating_cut");
		if (csatExamRatingCutSheet != null) {
			ratingCutVos = new ArrayList<RatingCutVo>();
			RatingCutVo ratingCutVo;
			XSSFRow csatExamRatingCutRow;
			int physicalNumberOfRows = csatExamRatingCutSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				csatExamRatingCutRow = csatExamRatingCutSheet.getRow(rowIndex);
				ratingCutVo = new RatingCutVo();
				ratingCutVo.setCsatSequence((int) csatExamRatingCutRow.getCell(0).getNumericCellValue());
				ratingCutVo.setRatingCode((int) csatExamRatingCutRow.getCell(1).getNumericCellValue());
				ratingCutVo.setExamSequence((int) csatExamRatingCutRow.getCell(2).getNumericCellValue());
				ratingCutVo.setSectionSequence((int) csatExamRatingCutRow.getCell(3).getNumericCellValue());  
				ratingCutVo.setSubjectSequence((int) csatExamRatingCutRow.getCell(4).getNumericCellValue());
				ratingCutVo.setRawScore((int) csatExamRatingCutRow.getCell(5).getNumericCellValue());
				ratingCutVo.setStandardScore((int) csatExamRatingCutRow.getCell(6).getNumericCellValue());
				ratingCutVos.add(ratingCutVo);
			}
		}
		return ratingCutVos;
	}
	
	/**
	 * 평균 리스트 입니다.
	 * 
	 * @return 평균 리스트
	 */
	public List<AverageVo> averageList() {
		List<AverageVo> averageVos = null;
		XSSFSheet csatExamAverageSheet = workbook.getSheet("csat_exam_avg");
		if (csatExamAverageSheet != null) {
			averageVos = new ArrayList<AverageVo>();
			AverageVo averageVo;
			XSSFRow csatAverageRow;
			int physicalNumberOfRows = csatExamAverageSheet.getPhysicalNumberOfRows();
			for (int rowIndex = 1; rowIndex < physicalNumberOfRows; rowIndex++) {
				csatAverageRow = csatExamAverageSheet.getRow(rowIndex);
				averageVo = new AverageVo();
				averageVo.setCsatSequence((int) csatAverageRow.getCell(0).getNumericCellValue());
				averageVo.setExamSequence((int) csatAverageRow.getCell(1).getNumericCellValue());
				averageVo.setSectionSequence((int) csatAverageRow.getCell(2).getNumericCellValue());
				averageVo.setSubjectSequence((int) csatAverageRow.getCell(3).getNumericCellValue());
				averageVo.setAverage((float) csatAverageRow.getCell(4).getNumericCellValue());
				averageVo.setStandardDeviation((float) csatAverageRow.getCell(5).getNumericCellValue());
				averageVos.add(averageVo);
			}
		}
		return averageVos;
	}

}