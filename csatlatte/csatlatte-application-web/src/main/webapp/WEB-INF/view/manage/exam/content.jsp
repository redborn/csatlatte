<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-exam-title">모의고사 관리</h4>
<div class="manage-exam-search">
	<div class="col-lg-5"><input type="text" class="form-control" placeholder="아이디 혹은 닉네임"></div>
</div>
<table class="table">
	<thead>
		<tr>
			<th class="col-lg-3">연도</th>
			<th class="col-lg-4">모의고사</th>
			<th class="col-lg-4">주관교육청</th>
			<th class="col-lg-1"></th>
			<th class="col-lg-1"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.year}</td>
			<td>${list.examName}</td>
			<td><div class="manage-question-content" data-toggle="modal" data-target="#manage-question-answer-view">${list.manageName}</div></td>
			<td><img alt="시험수정" data-toggle="modal" data-target="#manage-exam-modify" class="manage-exam-modify" src="<c:url value="/resources/csatlatte/images/btn/btn_modify.png"/>"></td>
			<td><img alt="시험지우기" data-toggle="modal" data-target="#manage-exam-delete" class="manage-exam-delete" src="<c:url value="/resources/csatlatte/images/btn/btn_delete.png"/>"></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="manage-exam-btn-align">
	<button class="btn btn-default manage-exam-add" data-toggle="modal" data-target="#manage-exam-add">모의고사 추가</button>
</div>
<nav>
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-exam-modify" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">모의고사 수정</h4>
			</div>
			<div class="modal-body">
				<div class="manage-exam-info-content">
					<label for="manage-exam-csat">수능</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-csat">
							<option>2016학년도 대학수학능력시험</option>
							<option>2015학년도 대학수학능력시험</option>
							<option>2014학년도 대학수학능력시험</option>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-name">모의고사</label>
					<div class="manage-exam-info-content-value">
						<input type="text" class="form-control" id="manage-exam-name">
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-eduoffice">주관 교육청</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-eduoffice">
							<option>한국교육과정평가원</option>
							<option>서울특별시교육청</option>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-student-grade">학년</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-student-grade">
							<option>3학년</option>
							<option>2학년</option>
							<option>1학년</option>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-file">등급컷 업로드</label>
					<div class="manage-exam-info-content-value">
						<input type="file" id="manage-exam-file">
					</div>
				</div>
				<div class="manage-exam-info-content">
					<a href="#">등급컷 다운로드</a>
				</div>
			</div>
			<div class="modal-footer">
				<img class="manage-exam-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="manage-exam-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-exam-delete" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">모의고사 삭제</h4>
			</div>
			<div class="modal-body">
				정말로 이 모의고사를 삭제하실거에요?
			</div>
			<div class="modal-footer">
				<img class="manage-exam-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="manage-exam-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
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
					<label for="manage-exam-csat">수능</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-csat">
							<option>2016학년도 대학수학능력시험</option>
							<option>2015학년도 대학수학능력시험</option>
							<option>2014학년도 대학수학능력시험</option>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-name">모의고사</label>
					<div class="manage-exam-info-content-value">
						<input type="text" class="form-control" id="manage-exam-name">
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-eduoffice">주관 교육청</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-eduoffice">
							<option>한국교육과정평가원</option>
							<option>서울특별시교육청</option>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-student-grade">학년</label>
					<div class="manage-exam-info-content-value">
						<select class="form-control" id="manage-exam-student-grade">
							<option>3학년</option>
							<option>2학년</option>
							<option>1학년</option>
						</select>
					</div>
				</div>
				<div class="manage-exam-info-content">
					<label for="manage-exam-file">등급컷 업로드</label>
					<div class="manage-exam-info-content-value">
						<input type="file" id="manage-exam-file">
					</div>
				</div>
				<div class="manage-exam-info-content">
					<a href="#">등급컷 다운로드</a>
				</div>
			</div>
			<div class="modal-footer">
				<img class="manage-exam-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="manage-exam-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>