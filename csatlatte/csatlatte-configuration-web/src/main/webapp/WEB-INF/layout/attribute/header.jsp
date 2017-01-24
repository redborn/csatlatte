<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/"/>">
				<img alt="Brand" src="<c:url value="/resources/csatlatte/images/header/img_logo.png"/>" />
			</a>
		</div> 
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/rating"/>">모의고사 등급컷</a></li>
				<li><a href="<c:url value="/grade"/>">내 성적 관리</a></li>
				<li><a href="<c:url value="/solving/select"/>">모의고사 풀기</a></li>
				<li><a href="<c:url value="/randomsolving/select"/>">임의 문제 풀기</a>
				<li><a href="<c:url value="/community"/>">커뮤니티</a></li>
				<li><a href="<c:url value="/support"/>">고객지원</a></li>
			<session:isManager>
				<li><a href="<c:url value="/stats/join"/>">관리자 페이지</a></li>
			</session:isManager>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<session:isGuest>
				<li><a href="<c:url value="/login"/>">로그인</a></li>
			</session:isGuest>
			<session:isLogin>
				<li><a href="${pageContext.request.contextPath}/<session:id/>">마이페이지</a></li>
				<li><a href="#" id="header-logout">로그아웃</a></li>
				<li><form:form id="header-logout-form" servletRelativeAction="/logout" method="POST" class="navbar-form navbar-right"></form:form></li>
			</session:isLogin>
			</ul>
		</div>
	</div>
</nav>