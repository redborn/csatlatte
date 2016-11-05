<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="solving-result-title">수고하셨습니다!</h3>
		<p>시험의 결과는 아래와 같습니다.</p>
		<p>이 결과는 시험 주관 교육청에서 발표한 자료에 근거했습니다.</p>
	</div>
	<div class="panel-body">
		<p>소요시간 / 시험시간 : </p>
		<p>잔여시간 : </p>
		<p>점수 : ${score}점</p>
		<p>등급 : ${rating}등급</p>
		<p>표준점수 : ${standardScore}점</p>
	</div>
</div>
<session:isGuest>
<div class="panel panel-default">
	<div class="panel-body">
		<h3 class="solving-result-title">수능라떼에 가입하면 더 많은 서비스를 이용할 수 있습니다.</h3>
		<p>위 결과를 내 성적 관리에 기록할 수 있습니다.</p>
		<p>커뮤니티를 통해 다른 사람과 의견을 공유해보세요.</p>
		<a href="<c:url value="/join"/>">수능라떼 가입하기</a>
	</div>
</div>
</session:isGuest>
<session:isStudent>
<div class="panel panel-default">
	<div class="panel-body">
		<h3 class="solving-result-title">당신의 성적을 관리할 수 있습니다.</h3>
		<p>모의고사 성적을 기록하고 당신의 성장을 분석해보세요.</p>
		<p>내 성적 관리에서 모의고사 성적을 기록할 수 있습니다.</p>
		<a href="<c:url value="/grade"/>">내 성적 관리하기</a>
	</div>
</div>
</session:isStudent>
<div class="alert alert-info" role="alert">
	<p><b>틀린 문제는 문제번호에 사선으로 표시됩니다.</b></p>
	<p>당신이 선택한 답은 문항에 파란색으로 표시되며, 틀린 문제의 경우 정답 문항이 빨간색으로 표시됩니다.</p>
	<p>문제 하단에는 해설이 적혀 있으니 참고하실 수 있습니다.</p>
</div>
<c:forEach items="${questionList}" var="question" varStatus="status">
	<div class="solving-result-question">
	<c:choose>
		<c:when test="${!marking[status.index]}">
		<div>
			<img class="solving-result-wrong-answer" alt="wrong-answer" src="<c:url value="/resources/csatlatte/images/img/img_wronganswer.png"/>"/>
			${question.questionSequence}. ${question.content}
		</div>
		</c:when>
		<c:otherwise>
		<div>
			<img class="solving-result-correct-answer" alt="correct-answer" src="<c:url value="/resources/csatlatte/images/img/img_correctanswer.png"/>"/>
			${question.questionSequence}. ${question.content}
		</div>
		</c:otherwise>
	</c:choose>
	<c:forEach items="${question.objectiveItemVos}" var="objectiveItem">
		<div class="solving-result-reply">
		<c:choose>
			<c:when test="${objectiveItem.objectiveItemSequence eq questionNumber[status.index]}"><div class="solving-result-reply-select">&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</div></c:when>
			<c:when test="${objectiveItem.objectiveItemSequence eq correctAnswerList[status.index].objectItemSequence}"><div class="solving-result-reply-correct-answer">&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</div></c:when>
			<c:otherwise>&#${objectiveItem.objectiveItemSequence + 10111};. ${objectiveItem.content}</c:otherwise>
		</c:choose>
		</div>
	</c:forEach>
	</div>
	<div class="solving-result-solution">
		${correctAnswerList[status.index].description}
	</div>
</c:forEach>