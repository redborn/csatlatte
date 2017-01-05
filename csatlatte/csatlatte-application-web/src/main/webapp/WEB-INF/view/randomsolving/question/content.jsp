<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">임의 문제 풀기</h2>
<form:form id="randomsolving-question-form" method="POST" servletRelativeAction="/randomsolving/${randomQuestion.csatSequence}/${randomQuestion.examSequence}/${randomQuestion.sectionSequence}/${randomQuestion.subjectSequence}/${randomQuestion.questionSequence}">
<p>${randomQuestion.examName}</p>
<c:if test="${randomQuestionText ne null}">
<div class="randomsolving-question-text">${randomQuestionText.content}</div>
</c:if>
${randomQuestion.questionSequence}. ${randomQuestion.content}
<c:forEach items="${randomQuestion.objectiveItemVos}" var="objectiveItem">
	<div class="radio"><label><input type="radio" class="answer" name="answer" value="${objectiveItem.objectiveItemSequence}">&nbsp;&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</label></div>
</c:forEach>
<div class="text-right">
	<a class="btn btn-default" href="<c:url value="/randomsolving/select"/>">문제 재설정</a>
	<a class="btn btn-default" id="randomsolving-question-refresh">다른 문제 풀기</a>
	<button class="btn btn-primary">제출</button>
</div>
</form:form>