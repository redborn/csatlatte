<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<c:forEach items="${questionList}" var="question">
	<a class="btn btn-default profile-question-list-button" href="${pageContext.request.contextPath}/<session:id/>/question/<session:studentSequence/>/${question.qnaSequence}">
		<span class="profile-question-list-title">${question.title}</span>
		<span class="glyphicon glyphicon-circle-arrow-right" aria-hidden="true"></span>
	</a>
</c:forEach>