<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4>등급컷 관리</h4>
<div class="col-lg-5">
	<select class="form-control" id="manage-rating-csat-list">
		<c:forEach items="${yearList}" var="year">
			<option value="${year.csatSequence}"<c:if test="${year.csatSequence eq '24'}"> selected</c:if>>${year.csatName}</option>
		</c:forEach>
	</select>
</div>
<table class="table" id="manage-rating-table">
	<thead>
		<tr>
			<th class="col-lg-2 manage-rating-col-lg">번호</th>
			<th class="col-lg-7 manage-rating-col-lg">모의고사 이름</th>
			<th class="col-lg-1 manage-rating-col-lg"></th>
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
	<div class="modal-dialog" role="document" id="manage-rating-modify-view-detail">
	</div>
</div>
<div class="modal fade" id="manage-rating-delete-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document" id="manage-rating-delete-view-detail">
	</div>
</div>
<div class="modal fade" id="manage-rating-create-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document" id="manage-rating-create-view-detail">
	</div>
</div>