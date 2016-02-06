<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2 style="color:#7a6253;">모의고사 등급컷</h2>
<div class="panel panel-default rating-panel">
	<div class="panel-heading">
		<h4>시험은 잘 보셨나요?</h4>
		<p>당신의 원점수와 등급을 비교해보세요.</p>
		<p>성적관리를 이용하면 조금 더 편하게 확인할 수 있습니다.</p>
	</div>
	<div class="panel-body">
		<div class="rating-select-grade">
			<h5><strong>학년 선택</strong></h5>
			<div class="rating-select-yearstudent-list">
				<c:forEach items="${yearStudentList}" var="yearStudent">
					<button class="rating-select-yearstudent-resource btn btn-default" data-loading-text="Loading..." value="${yearStudent.yearStudentSequence}" id="rating-select-yearstudent-resource-${yearStudent.yearStudentSequence}">${yearStudent.yearStudentName}</button>
				</c:forEach>
			</div>
		</div>
		<div class="rating-select-year">
			<h5><strong>연도 선택</strong></h5>
			<div class="rating-select-year-list">
			</div>
		</div>
		<div class="rating-select-exam">
			<h5><strong>모의고사 선택</strong></h5>
			<div class="rating-select-exam-list">
			</div>
		</div>
	</div>
</div>
<div class="rating-table-view"></div>