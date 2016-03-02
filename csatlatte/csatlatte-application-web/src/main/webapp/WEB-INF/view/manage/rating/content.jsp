<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4>등급컷 관리</h4>
<div class="col-lg-5">
	<select class="form-control" id="manage-rating-csat-list">
		<c:forEach items="${csatList}" var="csat">
			<option value="${csat.csatSequence}"<c:if test="${csat.csatSequence eq presentCsatSequence}"> selected</c:if>>${csat.csatName}</option>
		</c:forEach>
	</select>
</div>
<table class="table" id="manage-rating-table">
	<thead>
		<tr>
			<th class="col-lg-2 manage-rating-col-lg">번호</th>
			<th class="col-lg-8 manage-rating-col-lg">모의고사 이름</th>
			<th class="col-lg-1 manage-rating-col-lg"></th>
			<th class="col-lg-1 manage-rating-col-lg"></th>
		</tr>	
	</thead>
	<tbody class="manage-rating-row">
	</tbody>
</table>
<div class="manage-rating-btn-align">
	<button class="btn btn-default" id="manage-rating-create" data-toggle="modal" data-target="#manage-rating-create-view">등급컷 추가</button>
</div>
<div class="modal fade" id="manage-rating-modify-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<input type="hidden" value="PUT" name="_method">
		<div class="modal-content" id="manage-rating-modify-view-detail">
			<div class="modal-header">
				<button type="button" class="close manage-rating-modify-cancel" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">등급컷 수정</h4>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-rating-delete-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="manage-rating-delete-view-detail">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">등급컷 삭제</h4>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-rating-create-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="manage-rating-create-view-detail">
			<div class="modal-header">
				<button type="button" class="close manage-rating-create-cancel" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">등급컷 추가</h4>
			</div>
		</div>
	</div>
</div>
<div id="manage-rating-detail-view-detail"></div>