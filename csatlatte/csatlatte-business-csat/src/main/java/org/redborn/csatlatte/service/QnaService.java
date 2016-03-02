package org.redborn.csatlatte.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.redborn.csatlatte.domain.FileVo;
import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaVo;

/**
 * 문의 서비스입니다.
 */
public interface QnaService {

	/**
	 * 문의 내용입니다.
	 * 
	 * @param qnaSequence 문의 일련번호
	 * @return 문의 내용
	 */
	public QnaVo detail(int qnaSequence);
	
	/**
	 * 문의관리 리스트입니다.
	 * 
	 * @param search 검색
	 * @param pageNumber 페이지 번호
	 * @param countQnaAnswer 답변 유무
	 * @return 문의 리스트
	 */
	public List<QnaForManageVo> listForManage(String search, int pageNumber, int countQnaAnswer);
	
	/**
	 * 문의내역 리스트입니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return 문의 리스트
	 */
	public List<QnaVo> listForStudent(int studentSequence);
	
	/**
	 * 파일 리스트입니다.
	 * 
	 * @param qnaSequence 문의 일련번호
	 * @return 파일 리스트
	 */
	public List<FileVo> fileList(int qnaSequence);
	
	/**
	 * 문의를 삭제합니다.
	 * 
	 * @param qnaSequence 문의 일련번호
	 * @return 문의 삭제 성공 여부
	 */
	public boolean delete(int qnaSequence);
	
	/**
	 * 문의를 작성합니다.
	 * 
	 * @param qnaVo 문의 값
	 * @param files 첨부파일
	 * @param userAgent 학생 기기
	 * @param sessionId 학생 아이디
	 * @param ip 학생 아이피
	 * @return 문의 작성 성공 여부
	 */
	public boolean write(QnaVo qnaVo, List<File> files, String userAgent, String sessionId, String ip);
	
	/**
	 * 답변을 작성합니다.
	 * 
	 * @param qnaAnswerVo 문의답변 값
	 * @return 답변 작성 성공 여부
	 */
	public boolean answer(QnaAnswerVo qnaAnswerVo);
	
	/**
	 * 문의 수입니다.
	 * 
	 * @param search 검색
	 * @param countQnaAnswer 답변 유무
	 * @return 문의 수
	 */
	public int amountQuestion(String search, int countQnaAnswer);
	
	/**
	 * 작성자입니다.
	 * 
	 * @param qnaSequence 문의 일련번호
	 * @return 작성자 학생 일련번호
	 */
	public int getWriter(int qnaSequence);
	
	/**
	 * 파일이름입니다.
	 * 
	 * @param qnaSequence 문의 일련번호
	 * @param fileSequence 파일 일련번호
	 * @return 파일 이름
	 */
	public String getFilename(int qnaSequence, int fileSequence);
	
	/**
	 * InputStream입니다.
	 * 
	 * @param qnaSequence 문의 일련번호
	 * @param fileSequence 파일 일련번호
	 * @return InputStream
	 */
	public InputStream getInputStream(int qnaSequence, int fileSequence);
	
}
