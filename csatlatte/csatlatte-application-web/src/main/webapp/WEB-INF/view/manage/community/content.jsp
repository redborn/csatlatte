<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-community-title">커뮤니티 관리</h4>
<div class="manage-community-search">
	<div class="col-lg-5"><input type="text" class="form-control" placeholder="아이디 혹은 닉네임"></div>
</div>
<table class="table">
	<thead>
		<tr>
			<th class="col-lg-2">아이디</th>
			<th class="col-lg-2">닉네임</th>
			<th class="col-lg-4">내용</th>
			<th class="col-lg-2">블라인드</th>
			<th class="col-lg-1"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td><div data-toggle="modal" data-target="#manage-community-id" class="manage-community-id">${list.studentId}</div></td>
			<td>${list.nickname}</td>
			<td><div data-toggle="modal" data-target="#manage-community-text-detail" class="manage-community-text-detail">${list.content}</div></td>
			<td><input type="checkbox" <c:if test="${list.blind eq 1}">checked</c:if>></td>
			<td><img alt="글지우기" data-toggle="modal" data-target="#manage-community-delete" class="manage-community-delete" src="<c:url value="/resources/csatlatte/images/btn/btn_delete.png"/>"></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="manage-community-btn-align">
	<button class="btn btn-default manage-community-apply" data-toggle="modal" data-target="#manage-exam-add">적용</button>
</div>
<nav>
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-community-delete" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">게시글 삭제</h4>
			</div>
			<div class="modal-body">
				정말로 이 게시글을 삭제하실거에요?
			</div>
			<div class="modal-footer">
				<img class="manage-exam-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="manage-exam-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-community-id" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-user-info" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원정보</h4>
			</div>
			<div class="modal-body">
				<img class="manage-community-picture" alt="회원사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
				<div class="manage-community-info">
					<div class="manage-community-info-content">
						<label>아이디</label>
						<div class="manage-community-info-content-value">test</div>
					</div>
					<div class="manage-community-info-content">
						<label>가입일</label>
						<div class="manage-community-info-content-value">2013년 12월 21일 08시 22분 16초</div>
					</div>
					<div class="manage-community-info-content">
						<label>최근 접속일</label>
						<div class="manage-community-info-content-value">2015년 3월 7일 12시 37분 03초</div>
					</div>
					<div class="manage-community-info-content">
						<label>활동점수 내역</label>
						<div class="manage-community-info-content-value">게시글 3개, 댓글 15개</div>
					</div>
					<div class="manage-community-info-content">
						<label>성적평균</label>
						<div class="manage-community-info-content-value">3.2등급 / 420점</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-community-text-detail" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<div class="community-text">
					<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<div class="community-user-info">
						<div class="community-name"><strong>닉네임</strong></div>
						<div class="community-calender">2015-09-20 11:52:37</div>
					</div>
				<div class="dropdown">
					<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="<c:url value="/resources/csatlatte/images/btn/btn_menu.png"/>">
					<ul class="dropdown-menu" aria-labelledby="community-text-menu">
						<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-modify"><img alt="글수정" src="<c:url value="/resources/csatlatte/images/ico/ico_text_modify.png"/>"> | 글을 수정하고 싶어요.</div></li>	
						<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-delete"><img alt="글삭제" src="<c:url value="/resources/csatlatte/images/ico/ico_text_delete.png"/>"> | 글을 삭제할레요.</div></li>
						<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-report"><img alt="신고하기" src="<c:url value="/resources/csatlatte/images/ico/ico_report.png"/>"> | 신고하기</div></li>
					</ul>
				</div>
				</div>
			</div>
			<div class="modal-body">
				<div class="community-content">글 내용</div>
			</div>
			<div class="modal-footer">
				<div class="community-text">
					<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<div class="community-user-info">
						<div class="community-name"><strong>닉네임</strong></div>
						<div class="community-comment-content">내용</div>
						<div class="community-calender">2015-09-20 12:00:12</div>
					</div>
					<div class="dropdown">
						<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="<c:url value="/resources/csatlatte/images/btn/btn_menu.png"/>">
						<ul class="dropdown-menu" aria-labelledby="community-text-menu">
							<li><div class="dropdown-menu-resource">test1</div></li>
							<li><div class="dropdown-menu-resource">test1</div></li>	
							<li><div class="dropdown-menu-resource">test1</div></li>
							<li><div class="dropdown-menu-resource">test1</div></li>
						</ul>
					</div>
				</div>
				<div class="community-comment">
					<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<input type="text" class="form-control" placeholder="댓글을 입력해주세요.">
				</div>
			</div>
		</div>
	</div>
</div>