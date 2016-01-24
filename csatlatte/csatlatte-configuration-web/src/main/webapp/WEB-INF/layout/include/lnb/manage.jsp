<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h5>통계</h5>
<div class="list-group">
	<a class="list-group-item <c:if test="${param.active eq '/stats/join'}">active</c:if>" href="<c:url value="/stats/join"/>">가입자</a>
	<a class="list-group-item <c:if test="${param.active eq '/stats/connection'}">active</c:if>" href="<c:url value="/stats/connection"/>">접속자</a>
	<a class="list-group-item <c:if test="${param.active eq '/stats/community'}">active</c:if>" href="<c:url value="/stats/community"/>">커뮤니티 활성</a>
</div>
<h5>운영</h5>
<div class="list-group">
	<a class="list-group-item <c:if test="${param.active eq '/manage/user'}">active</c:if>" href="<c:url value="/manage/user"/>">회원 관리</a>
	<a class="list-group-item <c:if test="${param.active eq '/manage/exam'}">active</c:if>" href="<c:url value="/manage/exam"/>">모의고사 관리</a>
	<a class="list-group-item <c:if test="${param.active eq '/manage/rating'}">active</c:if>" href="<c:url value="/manage/rating"/>">등급컷 관리</a>
	<a class="list-group-item <c:if test="${param.active eq '/manage/community'}">active</c:if>" href="<c:url value="/manage/community"/>">커뮤니티 관리</a>
	<a class="list-group-item <c:if test="${param.active eq '/manage/question'}">active</c:if>" href="<c:url value="/manage/question"/>">문의 관리</a>
</div>