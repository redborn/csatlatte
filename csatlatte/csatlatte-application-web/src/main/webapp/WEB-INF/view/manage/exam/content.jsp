<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-exam-title">모의고사 관리</h4>
<div class="manage-exam-search">
	<div class="col-lg-5 manage-exam-col-lg"><input type="text" class="form-control" id="manage-exam-search" placeholder="모의고사 혹은 주관교육청" value="${param.search}"></div>
</div>
<table class="table" id="manage-exam-table">
	<thead>
		<tr>
			<th class="col-lg-1 manage-exam-col-lg">번호</th>
			<th class="col-lg-2 manage-exam-col-lg">연도</th>
			<th class="col-lg-6 manage-exam-col-lg">모의고사</th>
			<th class="col-lg-4 manage-exam-col-lg">주관교육청</th>
			<th class="col-lg-1 manage-exam-col-lg"></th>
			<th class="col-lg-1 manage-exam-col-lg"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="exam">
		<tr>
			<td>${exam.examSequence}</td>
			<td>${exam.year}</td>
			<td>${exam.examName}</td>
			<td><div class="manage-question-content" data-toggle="modal" data-target="#manage-question-answer-view">${exam.institutionName}</div></td>
			<td><button type="button" class="btn btn-default close manage-exam-icon"><span id="${exam.examSequence}" data-toggle="modal" data-target="#manage-exam-modify" class="manage-exam-modify glyphicon glyphicon-pencil"></span></button></td>
			<td><button type="button" class="btn btn-default close manage-exam-icon"><span id="${exam.examSequence}" data-toggle="modal" data-target="#manage-exam-delete" class="manage-exam-delete glyphicon glyphicon-remove"></span></button></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="manage-exam-btn-align">
	<button class="btn btn-default manage-exam-add" data-toggle="modal" data-target="#manage-exam-add">모의고사 추가</button>
</div>
<nav id="manage-exam-nav">
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-exam-modify" tabindex="-1" role="dialog">
	<div class="modal-dialog" id="manage-exam-modify-dialog" role="document">
	</div>
</div>
<div class="modal fade" id="manage-exam-delete" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">모의고사 삭제</h4>
			</div>
			<div class="modal-body" id="manage-exam-delete-modal-body">
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">닫기</button>
				<button class="btn btn-primary manage-exam-delete-accept">확인</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-exam-add" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">모의고사 추가</h4>
			</div>
			<div class="modal-body">
				<div class="manage-exam-info-content">
					<label class="manage-exam-label" for="manage-exam-csat">수능</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-csat"> 
							<c:forEach items="${yearList}" var="year">
								<option value="${year.csatSequence}">${year.csatName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label class="manage-exam-label" for="manage-exam-name">모의고사</label>
					<div class="manage-exam-info-content-value">
						<input type="text" class="form-control" id="manage-exam-name">
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label class="manage-exam-label" for="manage-exam-eduoffice">주관 교육청</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-eduoffice">
							<c:forEach items="${institutionList}" var="institution">
								<option value="${institution.institutionSequence}">${institution.institutionName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label class="manage-exam-label" for="manage-exam-student-grade">학년</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-student-grade">
							<c:forEach items="${ysList}" var="ys">
								<option value="${ys.ysSequence}">${ys.ysName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label class="manage-exam-label" for="manage-exam-file">등급컷 업로드</label>
					<div class="manage-exam-info-content-value">
						<input type="file" id="manage-exam-file">
					</div>
				</div>
				<div class="manage-exam-info-content">
					<a href="#">등급컷 다운로드</a>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">닫기</button>
				<button class="btn btn-primary">확인</button>
			</div>
		</div>
	</div>
</div>