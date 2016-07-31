<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">${examName}</h2>
<h2 style="color:#7a6253;">${subjectName}</h2>
<c:if test="${param.examTime eq 'on'}">
<div id="solving-list-exam-time-text">남은 시험 시간 : ${examTime}분 0초</div>
<input id="solving-list-exam-time" type="hidden" value="${examTime}"/>
</c:if>
<form:form id="solving-list-form" method="post" servletRelativeAction="/solving">
<c:forEach items="${questionList}" var="question">
	<div class="solving-list-question">
		<div>${question.questionSequence}. ${question.content}</div>
	<c:forEach items="${question.objectiveItemVos}" var="objectiveItem">
		<div class="radio"><label><input type="radio" name="${question.questionSequence}" value="${objectiveItem.objectiveItemSequence}">&nbsp;&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</label></div>
	</c:forEach>
	</div>
</c:forEach>
	<input type="submit" class="btn btn-primary btn-lg btn-block" value="제출"/>
</form:form>