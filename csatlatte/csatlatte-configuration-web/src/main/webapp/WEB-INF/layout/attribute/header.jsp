<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/main"/>">
				<img alt="Brand" src="<c:url value="/resources/csatlatte/images/header/img_logo.png"/>" />
			</a>
		</div> 
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/rating"/>">모의고사 등급컷</a></li>
				<li><a href="<c:url value="/grade"/>">내 성적 관리</a></li>
				<li><a href="<c:url value="/community"/>">커뮤니티</a></li>
				<li><a href="<c:url value="/support"/>">고객지원</a></li>
			<session:isManager>
				<li><a href="<c:url value="/stats/join"/>">관리자 페이지</a></li>
			</session:isManager>
			</ul>
		<session:isLogin>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/<session:id/>" class="btn btn-defaults btn-lg"><span class="glyphicon glyphicon-user"></span></a></li>
				<li><a href="<c:url value="/logout"/>" class="btn btn-defaults btn-lg"><span class="glyphicon glyphicon-off"></span></a></li>
			</ul>
		</session:isLogin>
		</div>
	</div>
</nav>