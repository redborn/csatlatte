<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4>모의고사 관리</h4>
<div class="col-lg-5">
	<select class="form-control" id="manage-exam-csat-list">
		<c:forEach items="${csatList}" var="csat">
			<option value="${csat.csatSequence}"<c:if test="${csat.csatSequence eq presentCsatSequence}"> selected</c:if>>${csat.csatName}</option>
		</c:forEach>
	</select>
</div>
<table class="table" id="manage-exam-table">
	<thead>
		<tr>
			<th class="col-lg-1 manage-exam-col-lg">번호</th>
			<th class="col-lg-1 manage-exam-col-lg">연도</th>
			<th class="col-lg-6 manage-exam-col-lg">모의고사</th>
			<th class="col-lg-3 manage-exam-col-lg">주관교육청</th>
			<th class="col-lg-1 manage-exam-col-lg">학년</th>
			<th class="col-lg-1 manage-exam-col-lg"></th>
			<th class="col-lg-1 manage-exam-col-lg"></th>
		</tr>
	</thead>
	<tbody class="manage-exam-row">
	</tbody>
</table>
<div class="manage-exam-btn-align">
	<button class="btn btn-default manage-exam-add" data-toggle="modal" data-target="#manage-exam-register-view">모의고사 추가</button>
</div>
<div class="modal fade" id="manage-exam-modify-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">모의고사 수정</h4>
			</div>
			<div class="modal-body" id="manage-exam-modify-view-detail">
			</div>
			<div class="modal-footer manage-exam-modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>
				<button type="button" class="btn btn-primary manage-exam-modify-accept">확인</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-exam-delete-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">모의고사 삭제</h4>
			</div>
			<div class="modal-body"  id="manage-exam-delete-view-detail">
			</div>
			<div class="modal-footer manage-exam-modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-exam-register-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">모의고사 추가</h4>
			</div>
			<div class="modal-body" id="manage-exam-register-view-detail">
			</div>
			<div class="modal-footer manage-exam-modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>
				<button type="button" class="btn btn-primary manage-exam-register-accept">확인</button>
			</div>
		</div>
	</div>
</div>