<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-question-title">문의 관리</h4>
<div class="row">
	<div class="col-lg-6">
	<div class="manage-question-yn">
		<h5>답변여부</h5>
		<div class="btn-group manage-question-btn-group">
			<button id="manage-question-all" class="btn btn-default <c:if test="${param.useYn eq null || param.useYn eq ''}">active</c:if>">전체</button>
			<button id="manage-question-standby" class="btn btn-default <c:if test="${param.useYn eq 'Y'}">active</c:if>">대기</button>
			<button id="manage-question-success" class="btn btn-default <c:if test="${param.useYn eq 'N'}">active</c:if>">완료</button>
		</div>
	</div>
	</div>
	<div class="manage-question-search">
		<div class="col-lg-5 manage-question-col-lg"><input type="text" class="form-control" id="manage-question-search" placeholder="아이디 혹은 닉네임"></div>
	</div>
</div>
<table class="table" id="manage-question-table">
	<thead>
		<tr>
			<th class="col-lg-1 manage-question-col-lg">번호</th>
			<th class="col-lg-2 manage-question-col-lg">아이디</th>
			<th class="col-lg-2 manage-question-col-lg">닉네임</th>
			<th class="col-lg-3 manage-question-col-lg">제목</th>
			<th class="col-lg-2 manage-question-col-lg">문의날짜</th>
			<th class="col-lg-1 manage-question-col-lg"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="question">
		<tr>
			<td>${question.qnaSequence}</td>
			<td>${question.studentId}</td>
			<td>${question.nickname}</td>
			<td>${question.title}</td>
			<td>${question.writeDate}</td>
			<td id="manage-question-answer-button-${question.qnaSequence}">
			<div id="manage-question-answer-button-div-${question.qnaSequence}">
				<button id="${question.qnaSequence}" data-toggle="modal" data-target="#manage-question-answer-view" class="manage-question-answer-view btn <c:if test="${question.useYn eq 'Y'}">btn-primary</c:if><c:if test="${question.useYn eq 'N'}">btn-default</c:if>"><c:if test="${question.useYn eq 'Y'}">답변</c:if><c:if test="${question.useYn eq 'N'}">확인</c:if></button>
			</div>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav class="manage-question-nav">
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-question-answer-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="manage-question-detail">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">문의 답변</h4>
			</div>
		</div>
	</div>
</div>