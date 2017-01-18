<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">임의 문제 풀기</h2>
<div class="alert alert-info" role="alert">
	<p><b>틀린 문제는 문제번호에 사선으로 표시됩니다.</b></p>
	<p>당신이 선택한 답은 문항에 파란색으로 표시되며, 틀린 문제의 경우 정답 문항이 빨간색으로 표시됩니다.</p>
	<p>문제 하단에는 해설이 적혀 있으니 참고하실 수 있습니다.</p>
</div>
<p>${randomQuestion.examName}</p>
<c:if test="${randomQuestionText ne null}">
<div class="randomsolving-result-text">${randomQuestionText.content}<br/>
${randomQuestionText.description}</div>
</c:if>
<c:choose>
	<c:when test="${!marking}">
		<img class="randomsolving-result-wrong-answer" alt="wrong-answer" src="<c:url value="/resources/csatlatte/images/img/img_wronganswer.png"/>"/>
	</c:when>
	<c:otherwise>
		<img class="randomsolving-result-correct-answer" alt="correct-answer" src="<c:url value="/resources/csatlatte/images/img/img_correctanswer.png"/>"/>
	</c:otherwise>
</c:choose>
${randomQuestion.questionSequence}. ${randomQuestion.content}
<c:forEach items="${randomQuestion.objectiveItemVos}" var="objectiveItem">
	<div class="randomsolving-result-reply">
	<c:choose>
		<c:when test="${objectiveItem.objectiveItemSequence eq param.answer}"><div class="randomsolving-result-reply-select">&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</div></c:when>
		<c:when test="${objectiveItem.objectiveItemSequence eq correctAnswer.objectItemSequence}"><div class="randomsolving-result-reply-correct-answer">&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</div></c:when>
		<c:otherwise>&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</c:otherwise>
	</c:choose>
	</div>
</c:forEach>
<div class="randomsolving-result-solution">
	${correctAnswer.description}
</div>
<div class="text-right">
	<a id="randomsolving-question-resetting" class="btn btn-default" href="
	<c:url value="/randomsolving/select">
		<c:forEach items="${yearStudentSequenceList}" var="yearStudentSequence">
			<c:param name="yearStudentSequenceList" value="${yearStudentSequence}"/>
		</c:forEach>
		<c:forEach items="${subjectSequenceList}" var="subjectSequence">
			<c:param name="subjectSequenceList" value="${subjectSequence}"/>
		</c:forEach>
	</c:url>">문제 재설정</a>
	<form:form id="randomsolving-result-form" method="GET" servletRelativeAction="/randomsolving">
		<c:forEach items="${yearStudentSequenceList}" var="yearStudentSequence">
			<input type="hidden" name="yearStudentSequenceList" value="${yearStudentSequence}"/>
		</c:forEach>
		<c:forEach items="${subjectSequenceList}" var="subjectSequence">
			<input type="hidden" name="subjectSequenceList" value="${subjectSequence}"/>
		</c:forEach>
		<button id="randomsolving-result-other-question" class="btn btn-default">다른 문제 풀기</button>
	</form:form>
</div>