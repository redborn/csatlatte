<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-user-title">회원 관리</h4>
<div class="manage-user-search">
	<form method="get" action="<c:url value="/manage/user"/>">
		<div class="col-lg-5 manage-user-col-lg"><input type="text" class="form-control" id="manage-student-search" placeholder="아이디 혹은 닉네임" name="search" value="${param.search}"></div>
	</form>
</div>
<table class="table" id="manage-user-table">
	<thead>
		<tr>
			<th class="col-lg-1 manage-user-col-lg">번호</th>
			<th class="col-lg-1 manage-user-col-lg">아이디</th>
			<th class="col-lg-1 manage-user-col-lg">닉네임</th>
			<th class="col-lg-1 manage-user-col-lg">접속횟수</th>
			<th class="col-lg-1 manage-user-col-lg">활동점수</th>
			<th class="col-lg-1 manage-user-col-lg">성적평균</th>
			<th class="col-lg-1 manage-user-col-lg">차단</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.studentSequence}</td>
			<td><div id="${user.studentSequence}" data-toggle="modal" data-target="#manage-user-id" class="manage-user-id">${user.studentId}</div></td>
			<td>${user.nickname}</td>
			<td>${user.countConnection}</td>
			<td>${user.countCommunity + user.countComment}</td>
			<td>${user.averageScore}</td>
			<td><div id="manage-user-blind-button-area-${user.studentSequence}">
				<c:choose>
					<c:when test="${user.useYn eq 'Y'}">
						<div id="blind-${user.studentSequence}">
							<button type="button" class="btn btn-default close manage-user-icon"><span id="${user.studentSequence}" data-toggle="modal" data-target="#manage-user-blind" class="glyphicon glyphicon-lock manage-user-blind"></span></button>
						</div>
					</c:when>
					<c:when test="${user.useYn eq 'N'}">
						<div id="recovery-${user.studentSequence}">
							<button type="button" class="btn btn-default close manage-user-icon"><span id="${user.studentSequence}" data-toggle="modal" data-target="#manage-user-recovery" class="glyphicon glyphicon-refresh manage-user-recovery"></span></button>
						</div>
					</c:when>
				</c:choose>
			</div></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav id="manage-user-nav">
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-user-id" tabindex="-1" role="dialog">
	<div class="modal-dialog manage-user-modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원정보</h4>
			</div>
			<div class="modal-body" id="manage-user-student-information">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-user-blind" tabindex="-1" role="dialog">
	<div class="modal-dialog manage-user-modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원차단</h4>
			</div>
			<div class="modal-body">
				정말로 차단하시겠습니까?
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>
				<button class="btn btn-primary manage-user-blind-apply">확인</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-user-recovery" tabindex="-1" role="dialog">
	<div class="modal-dialog manage-user-modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원복구</h4>
			</div>
			<div class="modal-body">
				정말로 차단을 해제하시겠습니까?
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>
				<button class="btn btn-primary manage-user-recovery-apply">확인</button>
			</div>
		</div>
	</div>
</div>