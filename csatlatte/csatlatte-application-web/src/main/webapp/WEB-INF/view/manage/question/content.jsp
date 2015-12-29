<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-question-title">문의 관리</h4>
<div class="row">
	<div class="col-lg-7">
		<div class="manage-question-yn">
			<h5>답변여부</h5>
			<div class="btn-group">
				<button id="manage-question-all" class="btn btn-default">전체</button>
				<button id="manage-question-standby" class="btn btn-default">대기</button>
				<button id="manage-question-success" class="btn btn-default">완료</button>
			</div>
		</div>
	</div>
		<div class="col-lg-5">
		<div class="manage-community-search">
			<div class="col-lg-12"><input type="text" class="form-control" placeholder="아이디 혹은 닉네임"></div>
		</div>
	</div>
</div>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>제목</th>
			<th>문의날짜</th>
			<th>완료여부</th>
		</tr>
	</thead>
	<tbody id="table-content">
	</tbody>
</table>
<nav>
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-question-answer-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				답변하기
			</div>
			<div class="modal-body">
			</div>
		</div>
	</div>
</div>