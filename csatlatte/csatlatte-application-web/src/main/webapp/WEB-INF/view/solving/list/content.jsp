<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 style="color:#7a6253;">${examName}</h2>
<h2 style="color:#7a6253;">${subjectName}</h2>
<input type="hidden" id="question-list-size" value="${questionListSize}"/>
<c:if test="${checkListenFile}">
<div class="alert alert-info">	
	<div class="media">
		<div class="media-left media-middle">
			<audio id="solving-list-listening">
				<source src="<c:url value="/file/listening/${csatSequence}/${examSequence}/${sectionSequence}/${subjectSequence}"/>" type="audio/mpeg">
			</audio>
			<button class="btn btn-default" id="solving-list-listening-button">
				<span class="glyphicon glyphicon-volume-up" aria-hidden="true"></span>
			</button>
		</div>
		<div class="media-body">
			<p>통신사 데이터를 사용하는 경우 데이터가 될 수 있습니다.</p>
			<p>좌측 아이콘을 누르면 듣기 평가가 시작됩니다. 1회만 재생 가능하니 이 점 유의하시기 바랍니다.</p>
			<p>듣기 평가를 재생 중에는 재생을 중지할 수 없습니다.</p>
		</div>
	</div>
</div>
</c:if>
<c:set value="0" var="textIndex"/>
<form:form id="solving-list-form" method="post" servletRelativeAction="/solving/${csatSequence}/${examSequence}/${sectionSequence}/${subjectSequence}">
<c:if test="${param.examTime eq 'on'}">
	<div class="alert alert-danger" role="alert" id="solving-list-exam-time-alert"></div>
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