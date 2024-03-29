<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h4 class="manage-question-title">문의 관리</h4>
<div class="row">
	<div class="col-lg-6">
	<div class="manage-question-yn">
		<h5>답변여부</h5>
		<div class="btn-group manage-question-btn-group">
			<a href="<c:url value="/manage/question"/>" id="manage-question-all" class="btn btn-default <c:if test="${param.countQnaAnswer == null || param.countQnaAnswer eq '' || param.countQnaAnswer eq '2'}">active</c:if>">전체</a>
			<a href="<c:url value="/manage/question?countQnaAnswer=0"/>" id="manage-question-standby" class="btn btn-default <c:if test="${param.countQnaAnswer eq '0'}">active</c:if>">대기</a>
			<a href="<c:url value="/manage/question?countQnaAnswer=1"/>" id="manage-question-success" class="btn btn-default <c:if test="${param.countQnaAnswer eq '1'}">active</c:if>">완료</a>
		</div>
	</div>
	</div>
	<div class="manage-question-search">
		<form:form method="get" servletRelativeAction="/manage/question">
			<div class="col-lg-5 manage-question-col-lg"><input type="text" class="form-control" id="manage-question-search" placeholder="아이디 혹은 닉네임" name="search" value="${param.search}"></div>
		</form:form>
	</div>
</div>
<table class="table" id="manage-question-table">
	<thead>
		<tr>
			<th class="manage-question-sequence col-lg-1 manage-question-col-lg">번호</th>
			<th class="col-lg-2 manage-question-col-lg">아이디</th>
			<th class="col-lg-2 manage-question-col-lg manage-question-nickname">닉네임</th>
			<th class="col-lg-3 manage-question-col-lg">제목</th>
			<th class="col-lg-2 manage-question-col-lg">날짜</th>
			<th class="col-lg-1 manage-question-col-lg"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="question">
		<tr>
			<td class="manage-question-sequence">${question.qnaSequence}</td>
			<td>${question.studentId}</td>
			<td class="manage-question-nickname">${question.nickname}</td>
			<td><div class="manage-question-title"><xmp>${question.title}</xmp></div></td>
			<td>${question.writeDate}</td>
			<td id="manage-question-answer-button-${question.qnaSequence}">
			<div id="manage-question-answer-button-div-${question.qnaSequence}">
				<button id="${question.qnaSequence}" data-toggle="modal" data-target="#manage-question-answer-view" class="manage-question-answer-view btn <c:if test="${question.countQnaAnswer eq '0'}">btn-primary</c:if><c:if test="${question.countQnaAnswer eq '1'}">btn-default</c:if>"><c:if test="${question.countQnaAnswer eq '0'}">답변</c:if><c:if test="${question.countQnaAnswer eq '1'}">확인</c:if></button>
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
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">문의 답변</h4>
			</div>
			<div class="modal-body" id="manage-question-detail">
			</div>
			<div class="modal-footer" id="manage-question-detail-footer">
			</div>
		</div>
	</div>
</div>