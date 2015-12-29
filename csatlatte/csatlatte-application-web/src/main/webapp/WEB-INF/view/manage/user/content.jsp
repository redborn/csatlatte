<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-user-title">회원 관리</h4>
<div class="manage-user-search">
	<div class="col-lg-5"><input type="text" class="form-control" placeholder="아이디 혹은 닉네임"></div>
</div>
<table class="table">
	<thead>
		<tr>
			<th class="col-lg-1">번호</th>
			<th class="col-lg-1">아이디</th>
			<th class="col-lg-1">닉네임</th>
			<th class="col-lg-1">접속횟수</th>
			<th class="col-lg-1">차단</th>
			<th class="col-lg-1">활동점수</th>
			<th class="col-lg-1">성적평균</th>
		</tr>
	</thead>
	<tbody id="table-content">
	</tbody>
</table>
<div class="manage-user-apply-align">
	<input type="submit" class="btn btn-default manage-user-apply" value="적용">
</div>
<nav>
	<pagination:writer value="${paginationWriter}"/>
</nav>
<!-- <c:forEach items="${userList}" var="userList">
<div class="modal fade" id="manage-user-id${userList.studentSequence}" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원정보</h4>
			</div>
			<div class="modal-body">
				<img class="manage-user-picture" alt="회원사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
				<div class="manage-user-info">
					<div class="manage-user-info-content">
						<label>아이디</label>
						<div class="manage-user-info-content-value">${userList.studentId}</div>
					</div>
					<div class="manage-user-info-content">
						<label>가입일</label>
						<div class="manage-user-info-content-value">${userList.createDate}</div>
					</div>
					<div class="manage-user-info-content">
						<label>최근 접속일</label>
						<div class="manage-user-info-content-value">${userList.lastConnection}</div>
					</div>
					<div class="manage-user-info-content">
						<label>활동점수 내역</label>
						<div class="manage-user-info-content-value">게시글 ${userList.countCommunity}개, 댓글 ${userList.countComment}개</div>
					</div>
					<div class="manage-user-info-content">
						<label>성적평균</label>
						<div class="manage-user-info-content-value">${userList.averageScore}점</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</c:forEach> -->