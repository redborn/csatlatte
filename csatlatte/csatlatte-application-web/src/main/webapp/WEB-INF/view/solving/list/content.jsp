<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">${examName}</h2>
<h2 style="color:#7a6253;">${subjectName}</h2>
<input type="hidden" id="question-list-size" value="${questionListSize}"/>
<c:set value="0" var="textIndex"/>
<form:form id="solving-list-form" method="post" servletRelativeAction="/solving/${csatSequence}/${examSequence}/${sectionSequence}/${subjectSequence}">
<c:if test="${param.examTime eq 'on'}">
	<div id="solving-list-exam-time-text">남은 시험 시간 : ${examTime}분 0초</div>
	<input name="examTime" id="solving-list-exam-time" type="hidden" value="${examTime}"/>
	<input name="examTimeUse" type="hidden" value="${param.examTime eq 'on'}"/>
	<input name="resultExamTime" id="solving-list-result-exam-time" type="hidden" value="${examTime * 60}"/>
</c:if>
<c:forEach items="${questionList}" var="question" varStatus="status">
	<c:if test="${textList[textIndex].beginQuestionSequence eq (status.index + 1)}">${textList[textIndex].content}</c:if>
	<c:if test="${textList[textIndex].endQuestionSequence eq (status.index + 1)}"><c:set var="textIndex" value="${textIndex + 1}"/></c:if>
	<div class="solving-list-question">
		<div>${question.questionSequence}. ${question.content}</div>
	<c:forEach items="${question.objectiveItemVos}" var="objectiveItem">
		<div class="radio"><label><input type="radio" class="answer" name="${question.questionSequence}" value="${objectiveItem.objectiveItemSequence}">&nbsp;&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</label></div>
	</c:forEach>
	</div>
</c:forEach>
	<input type="hidden" id="question-answer-result" name="result" value=""/>
	<input type="submit" class="btn btn-primary btn-lg btn-block" value="제출" id="submit"/>
</form:form>