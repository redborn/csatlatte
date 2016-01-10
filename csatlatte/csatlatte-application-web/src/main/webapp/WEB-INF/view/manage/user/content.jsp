<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-user-title">회원 관리</h4>
<div class="manage-user-search">
	<div class="col-lg-5"><input type="text" class="form-control" id="manage-student-search" placeholder="아이디 혹은 닉네임"></div>
</div>
<table class="table">
	<thead>
		<tr>
			<th class="col-lg-1">번호</th>
			<th class="col-lg-1">아이디</th>
			<th class="col-lg-1">닉네임</th>
			<th class="col-lg-1">접속횟수</th>
			<th class="col-lg-1">활동점수</th>
			<th class="col-lg-1">성적평균</th>
			<th class="col-lg-1">차단</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${userList}" var="userList">
		<tr>
			<td>${userList.studentSequence}</td>
			<td><div id="${userList.studentSequence}" data-toggle="modal" data-target="#manage-user-id" class="manage-user-id">${userList.studentId}</div></td>
			<td>${userList.nickname}</td>
			<td>${userList.countConnection}</td>
			<td>${userList.countCommunity + userList.countComment}</td>
			<td>${userList.averageScore}</td>
			<td><div id="manage-user-blind-button-area${userList.studentSequence}">
				<c:choose>
					<c:when test="${userList.useYn eq 'Y'}">
						<div id="blind${userList.studentSequence}">
							<button type="button" class="btn btn-default close"><span id="${userList.studentSequence}" data-toggle="modal" data-target="#manage-user-blind" class="glyphicon glyphicon-lock manage-user-blind"></span></button>
						</div>
					</c:when>
					<c:when test="${userList.useYn eq 'N'}">
						<div id="recovery${userList.studentSequence}">
							<button type="button" class="btn btn-default close"><span id="${userList.studentSequence}" data-toggle="modal" data-target="#manage-user-recovery" class="glyphicon glyphicon-refresh manage-user-recovery"></span></button>
						</div>
					</c:when>
				</c:choose>
			</div></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav>
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-user-id" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
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
	<div class="modal-dialog" role="document">
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
	<div class="modal-dialog" role="document">
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