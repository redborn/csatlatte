<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2 style="color:#7a6253;">임의 문제 풀기</h2>
<c:set var="selectedYearStudentSequenceIndex" value="0"/>
<c:set var="selectedSubjectSequenceIndex" value="0"/>
<form:form id="randomsolving-select-form" method="get" servletRelativeAction="/randomsolving/">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 id="randomsolving-select-title">모의고사에 출제된 문제를 풀어보세요.</h3>
			<p>아래에서 간단한 설정을 하고 시작해보세요.</p>
			<p>무거운 문제집을 들고다니는 것보다 편합니다.</p>
		</div>
		<div class="panel-body">
			<h5><strong>학년 선택</strong></h5>
			<c:forEach items="${yearStudentList}" var="yearStudent">
				<div class="checkbox"><label><input class="randomsolving-select-year-student" type="checkbox" name="yearStudentSequence" value="${yearStudent.yearStudentSequence}" <c:if test="${paramValues.yearStudentSequence[selectedYearStudentSequenceIndex] eq yearStudent.yearStudentSequence}">checked<c:set var="selectedYearStudentSequenceIndex" value="${selectedYearStudentSequenceIndex + 1}"/></c:if>/>${yearStudent.yearStudentName}</label></div>
			</c:forEach>
			<h5><strong>과목 선택</strong></h5>
			<div class="checkbox"><label><input class="randomsolving-select-subject" type="checkbox" name="subjectSequence" value="1" <c:if test="${paramValues.subjectSequence[selectedSubjectSequenceIndex] eq 1}">checked<c:set var="selectedSubjectSequenceIndex" value="${selectedSubjectSequenceIndex + 1}"/></c:if>/>국어</label></div>
			<div class="checkbox"><label><input class="randomsolving-select-subject" type="checkbox" name="subjectSequence" value="5" <c:if test="${paramValues.subjectSequence[selectedSubjectSequenceIndex] eq 5}">checked</c:if>/>영어</label></div>
		</div>
		<div class="panel-footer text-right">
			<input id="randomsolving-select-start" class="btn btn-primary" type="submit" value="시작"/>
		</div>
	</div>
</form:form>