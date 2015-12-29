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
			<th class="col-lg-2">번호</th>
			<th class="col-lg-2">아이디</th>
			<th class="col-lg-2">닉네임</th>
			<th class="col-lg-4">내용</th>
			<th class="col-lg-2">블라인드</th>
		</tr>
	</thead>
	<tbody id="table-content">
	</tbody>
</table>
<div class="manage-community-btn-align">
	<button class="btn btn-default manage-community-apply">적용</button>
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
			<div class="modal-body" id="manage-community-student-information">
			</div>
		</div>
	</div>
</div>
<div id="manage-community-text-detail-area"></div>