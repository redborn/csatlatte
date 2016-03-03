package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CommentVo;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.TypeVo;

/**
 * 커뮤니티 서비스입니다.
 */
public interface CommunityService {
	
	/**
	 * 기본 커뮤니티 일련번호
	 */
	public static final int COMMUNITY = 1;

	/**
	 * 글 갯수입니다.
	 * 
	 * @param search 검색
	 * @return 글 갯수
	 */
	public int getCount(String search);
	
	/**
	 * 글을 블라인드합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param blindTypeSequence 블라인드 일련번호
	 * @return 글 블라인드 성공 여부
	 */
	public boolean blind(int communityTypeSequence, int communitySequence, int blindTypeSequence);
	
	/**
	 * 글을 작성합니다.
	 * 
	 * @param communityVo 커뮤니티 값
	 * @param userAgent 학생 기기
	 * @param sessionId 학생 아이디
	 * @param ip 학생 아이피
	 * @return 글 작성 성공 여부
	 */
	public boolean write(CommunityVo communityVo, String userAgent, String sessionId, String ip);
	
	/**
	 * 글을 삭제합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 글 삭제 성공 여부
	 */
	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence);
	
	/**
	 * 댓글을 블라인드합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param blindTypeSequence 블라인드 일련번호
	 * @return 글 블라인드 성공 여부
	 */
	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, int blindTypeSequence);
	
	/**
	 * 댓글을 작성합니다.
	 * 
	 * @param commentVo 댓글 값
	 * @param userAgent 학생 기기
	 * @param sessionId 학생 아이디
	 * @param ip 학생 아이피
	 * @return 댓글 작성 성공 여부
	 */
	public boolean writeComment(CommentVo commentVo, String userAgent, String sessionId, String ip);
	
	/**
	 * 댓글을 삭제합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 댓글 삭제 성공 여부
	 */
	public boolean deleteComment(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	
	/**
	 * 글 리스트입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param start 첫번째 커뮤니티 일련번호
	 * @param end 마지막 커뮤니티 일련번호
	 * @param limit 커뮤니티 글 수
	 * @param studentSequence 학생 일련번호
	 * @return 글 리스트
	 */
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence);
	
	/**
	 * 글 리스트입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param start 첫번째 커뮤니티 일련번호
	 * @param end 마지막 커뮤니티 일련번호
	 * @param limit 커뮤니티 글 수
	 * @param studentSequence 학생 일련번호
	 * @param searchStudentSequence 
	 * @return 글 리스트
	 */
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence, int searchStudentSequence);
	
	/**
	 * 커뮤니티 관리 리스트입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param search 검색
	 * @param pageNumber 페이지 번호
	 * @return 글 리스트
	 */
	public List<CommunityVo> list(int communityTypeSequence, String search, int pageNumber);
	
	/**
	 * 내가 작성한 글 리스트입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 글 리스트
	 */
	public List<CommunityVo> list(int communityTypeSequence, int studentSequence);
	
	/**
	 * 댓글 리스트입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param studentSequence 학생 일련번호
	 * @return 댓글 리스트
	 */
	public List<CommentVo> commentList(int communityTypeSequence, int communitySequence, int studentSequence);
	
	/**
	 * 블라인드사유 리스트입니다.
	 * 
	 * @return 블라인드사유 리스트
	 */
	public List<TypeVo> blindTypeList();
	
	/**
	 * 신고사유 리스트입니다.
	 * 
	 * @return 신고사유 리스트
	 */
	public List<TypeVo> reportTypeList();
	
	/**
	 * 글을 신고합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param reportTypeSequence 신고 일련번호
	 * @param userAgent 학생 기기
	 * @param sessionId 학생 아이디
	 * @param ip 학생 아이피
	 * @return 글 신고 성공 여부
	 */
	public boolean report(int studentSequence,int communityTypeSequence, int communitySequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	
	/**
	 * 댓글을 신고합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param reportTypeSequence 신고 일련번호
	 * @param userAgent 학생 기기
	 * @param sessionId 학생 아이디
	 * @param ip 학생 아이피
	 * @return 댓글 신고 성공 여부
	 */
	public boolean reportComment(int studentSequence,int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	
	/**
	 * 일간 커뮤니티 활성입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param ymd 연월일
	 * @return 시간별 커뮤니티 활성 리스트
	 */
	public List<CountVo> dailyActive(int communityTypeSequence, String ymd);
	
	/**
	 * 월간 커뮤니티 활성입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param ym 연월
	 * @return 일별 커뮤니티 활성 리스트
	 */
	public List<CountVo> monthlyActive(int communityTypeSequence, String ym);
	
	/**
	 * 연간 커뮤니티 활성입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param year 연도
	 * @return 월별 커뮤니티 활성 리스트
	 */
	public List<CountVo> annualActive(int communityTypeSequence, String year);
	
	/**
	 * 글 내용입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @return 글 내용
	 */
	public CommunityVo detail(int communityTypeSequence, int communitySequence);
	
}
