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
	 * @return
	 */
	public int getCount(String search);
	
	/**
	 * 글을 블라인드합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param blindTypeSequence 블라인드 일련번호
	 * @return
	 */
	public boolean blind(int communityTypeSequence, int communitySequence, int blindTypeSequence);
	
	/**
	 * 글을 작성합니다.
	 * 
	 * @param communityVo 커뮤니티 값
	 * @param userAgent 사용자 기기
	 * @param sessionId 사용자 아이디
	 * @param ip 사용자 아이피
	 * @return
	 */
	public boolean write(CommunityVo communityVo, String userAgent, String sessionId, String ip);
	
	/**
	 * 글을 삭제합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public boolean delete(int communityTypeSequence, int communitySequence, int studentSequence);
	
	/**
	 * 댓글을 블라인드합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param blindTypeSequence 블라인드 일련번호
	 * @return
	 */
	public boolean blindComment(int communityTypeSequence, int communitySequence, int commentSequence, int blindTypeSequence);
	
	/**
	 * 댓글을 작성합니다.
	 * 
	 * @param commentVo 댓글 값
	 * @param userAgent 사용자 기기
	 * @param sessionId 사용자 아이디
	 * @param ip 사용자 아이피
	 * @return
	 */
	public boolean writeComment(CommentVo commentVo, String userAgent, String sessionId, String ip);
	
	/**
	 * 댓글을 삭제합니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public boolean deleteComment(int communityTypeSequence, int communitySequence, int commentSequence, int studentSequence);
	
	/**
	 * 글 목록입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param start 첫번째 커뮤니티 일련번호
	 * @param end 마지막 커뮤니티 일련번호
	 * @param limit 커뮤니티 글 수
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence);
	
	/**
	 * 글 목록입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param start 첫번째 커뮤니티 일련번호
	 * @param end 마지막 커뮤니티 일련번호
	 * @param limit 커뮤니티 글 수
	 * @param studentSequence 사용자 일련번호
	 * @param searchStudentSequence 
	 * @return
	 */
	public List<CommunityVo> list(int communityTypeSequence, int start, int end, int limit, int studentSequence, int searchStudentSequence);
	
	/**
	 * 커뮤니티 관리 목록입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param search 검색
	 * @param pageNumber 페이지 번호
	 * @return
	 */
	public List<CommunityVo> list(int communityTypeSequence, String search, int pageNumber);
	
	/**
	 * 내가 작성한 글 목록입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public List<CommunityVo> list(int communityTypeSequence, int studentSequence);
	
	/**
	 * 댓글 목록입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public List<CommentVo> commentList(int communityTypeSequence, int communitySequence, int studentSequence);
	
	/**
	 * 블라인드사유 목록입니다.
	 * 
	 * @return
	 */
	public List<TypeVo> blindTypeList();
	
	/**
	 * 신고사유 목록입니다.
	 * 
	 * @return
	 */
	public List<TypeVo> reportTypeList();
	
	/**
	 * 글을 신고합니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param reportTypeSequence 신고 일련번호
	 * @param userAgent 사용자 기기
	 * @param sessionId 사용자 아이디
	 * @param ip 사용자 아이피
	 * @return
	 */
	public boolean report(int studentSequence,int communityTypeSequence, int communitySequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	
	/**
	 * 댓글을 신고합니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param reportTypeSequence 신고 일련번호
	 * @param userAgent 사용자 기기
	 * @param sessionId 사용자 아이디
	 * @param ip 사용자 아이피
	 * @return
	 */
	public boolean reportComment(int studentSequence,int communityTypeSequence, int communitySequence, int commentSequence, int reportTypeSequence, String userAgent, String sessionId, String ip);
	
	/**
	 * 일간 커뮤니티 활성입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param ymd 연월일
	 * @return
	 */
	public List<CountVo> dailyActive(int communityTypeSequence, String ymd);
	
	/**
	 * 월간 커뮤니티 활성입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param ym 연월
	 * @return
	 */
	public List<CountVo> monthlyActive(int communityTypeSequence, String ym);
	
	/**
	 * 연간 커뮤니티 활성입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param year 연도
	 * @return
	 */
	public List<CountVo> annualActive(int communityTypeSequence, String year);
	
	/**
	 * 글 상세내용입니다.
	 * 
	 * @param communityTypeSequence 게시판 일련번호
	 * @param communitySequence 커뮤니티 일련번호
	 * @return
	 */
	public CommunityVo detail(int communityTypeSequence, int communitySequence);
	
}
