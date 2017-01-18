<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">임의 문제 풀기</h2>
<form:form id="randomsolving-select-form" method="get" servletRelativeAction="/randomsolving/">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 id="randomsolving-select-title">모의고사에 출제된 문제를 풀어보세요.</h3>
			<p>아래에서 간단한 설정을 하고 시작해보세요.</p>
			<p>무거운 문제집을 들고다니는 것보다 편합니다.</p>
		</div>
		<div class="panel-body">
			<h5><strong>학년 선택</strong></h5>
			<div class="checkbox"><label><input class="randomsolving-year-student" type="checkbox" name="yearStudentSequenceList" value="3" <c:forEach items="${yearStudentSequenceList}" var="yearStudentSequence"><c:if test="${yearStudentSequence eq 3}">checked</c:if></c:forEach>/>3학년</label></div>
			<div class="checkbox"><label><input class="randomsolving-year-student" type="checkbox" name="yearStudentSequenceList" value="2" <c:forEach items="${yearStudentSequenceList}" var="yearStudentSequence"><c:if test="${yearStudentSequence eq 2}">checked</c:if></c:forEach>/>2학년</label></div>
			<div class="checkbox"><label><input class="randomsolving-year-student" type="checkbox" name="yearStudentSequenceList" value="1" <c:forEach items="${yearStudentSequenceList}" var="yearStudentSequence"><c:if test="${yearStudentSequence eq 1}">checked</c:if></c:forEach>/>1학년</label></div>
			<h5><strong>과목 선택</strong></h5>
			<div class="checkbox"><label><input type="checkbox" name="subjectSequenceList" value="1" <c:forEach items="${subjectSequenceList}" var="subjectSequence"><c:if test="${subjectSequence eq 1}">checked</c:if></c:forEach>/>국어</label></div>
			<div class="checkbox"><label><input type="checkbox" name="subjectSequenceList" value="5" <c:forEach items="${subjectSequenceList}" var="subjectSequence"><c:if test="${subjectSequence eq 5}">checked</c:if></c:forEach>/>영어</label></div>
		</div>
		<div class="panel-footer text-right">
			<input class="btn btn-primary" type="submit" value="시작"/>
		</div>
	</div>
</form:form>