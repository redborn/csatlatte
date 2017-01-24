<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">임의 문제 풀기</h2>
<form:form id="randomsolving-question-form" method="POST" servletRelativeAction="/randomsolving">
<input type="hidden" name="questionCsatSequence" value="${randomQuestion.csatSequence}"/>
<input type="hidden" name="questionExamSequence" value="${randomQuestion.examSequence}"/>
<input type="hidden" name="questionSectionSequence" value="${randomQuestion.sectionSequence}"/>
<input type="hidden" name="questionSubjectSequence" value="${randomQuestion.subjectSequence}"/>
<input type="hidden" name="questionSequence" value="${randomQuestion.questionSequence}"/>
<c:forEach items="${paramValues.yearStudentSequence}" var="yearStudentSequence">
	<input type="hidden" name="yearStudentSequence" value="${yearStudentSequence}"/>
</c:forEach>
<c:forEach items="${paramValues.subjectSequence}" var="subjectSequence">
	<input type="hidden" name="subjectSequence" value="${subjectSequence}"/>
</c:forEach>
<p>${randomQuestion.examName}&nbsp;-&nbsp;${subjectName}</p>
<c:if test="${randomQuestionText ne null}">
<div class="randomsolving-question-text">${randomQuestionText.content}</div>
</c:if>
${randomQuestion.questionSequence}. ${randomQuestion.content}
<c:forEach items="${randomQuestion.objectiveItemVos}" var="objectiveItem">
	<div class="radio"><label><input type="radio" class="answer randomsolving-question-answer" name="answer" value="${objectiveItem.objectiveItemSequence}">&nbsp;&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</label></div>
</c:forEach>
<div class="text-right">
	<a id="randomsolving-question-resetting" class="btn btn-default" href="
	<c:url value="/randomsolving/select">
		<c:forEach items="${paramValues.yearStudentSequence}" var="yearStudentSequence">
			<c:param name="yearStudentSequence" value="${yearStudentSequence}"/>
		</c:forEach>
		<c:forEach items="${paramValues.subjectSequence}" var="subjectSequence">
			<c:param name="subjectSequence" value="${subjectSequence}"/>
		</c:forEach>
	</c:url>">문제 재설정</a>
	<a class="btn btn-default" id="randomsolving-question-refresh">다른 문제 풀기</a>
	<button id="randomsolving-question-submit" class="btn btn-primary" disabled>제출</button>
</div>
</form:form>