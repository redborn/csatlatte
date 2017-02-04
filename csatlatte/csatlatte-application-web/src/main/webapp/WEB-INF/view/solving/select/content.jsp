<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">모의고사 풀기</h2>
<form:form id="solving-select-form" method="get" servletRelativeAction="/solving/">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>이제 모의고사 출제문제를 풀어보세요.</h3>
			<p>당신의 학습 환경을 크게 개선해줄 것입니다.</p>
			<p>아래 순서대로 시험을 선택해보세요.</p>
		</div>
		<div class="panel-body">
			<div>
				<input type="checkbox" id="solving-select-time" name="examTime"/><label for="solving-select-time">&nbsp;시험 시간 사용&nbsp;</label><small>실제 모의고사의 시험 시간이 적용됩니다. 시험 시간이 지나면 자동으로 시험이 제출됩니다.</small>
			</div>
			<div>
				<h5><strong>학년 선택</strong></h5>
				<div class="solving-select-yearstudent-list">
					<c:forEach items="${yearStudentList}" var="yearStudent">
						<button type="button" class="solving-select-yearstudent-resource btn btn-default" data-loading-text="Loading..." id="solving-select-yearstudent-resource-${yearStudent.yearStudentSequence}">${yearStudent.yearStudentName}</button>
					</c:forEach>
				</div>
			</div>
			<div id="solving-select-year">
				<h5><strong>연도 선택</strong></h5>
				<div id="solving-select-year-list"></div>
			</div>
			<div id="solving-select-exam">
				<h5><strong>모의고사 선택</strong></h5>
				<div id="solving-select-exam-list"></div>
			</div>
			<div id="solving-select-subject">
				<h5><strong>과목 선택</strong></h5>
				<div id="solving-select-subject-list"></div>
			</div>
		</div>
		<div class="panel-footer text-right">
			<input id="solving-select-submit" type="submit" class="btn btn-primary" value="시작" disabled="disabled"/>
		</div>
	</div>
</form:form>