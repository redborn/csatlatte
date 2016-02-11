<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="main-picture">
	<div class="main-title">"미래를 위한<br/>현명한 준비"</div>
	<session:isGuest>
	<div class="main-login">
		<form:form id="main-form" method="post" servletRelativeAction="/login"> 
			<div class="form-group">
				<label for="main-input-id" class="sr-only">수능라떼 아이디</label>
				<input type="text" name="id" class="form-control" placeholder="수능라떼 아이디" id="main-input-id"/>
			</div>
			<div class="form-group">
				<label for="main-input-password" class="sr-only">수능라떼 비밀번호</label>
				<input type="password" name="password" class="form-control" placeholder="수능라떼 비밀번호" id="main-input-password"/>
			</div>
			<div class="form-group" id="main-maintain-login">
				<input id="main-login-keep-status" type="checkbox"/>
				<label for="main-login-keep-status">로그인 상태 유지</label>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-default" value="로그인"/>
			</div>
			<div class="form-group" id="main-account">
				<div class="main-join">
					<a href="<c:url value="/join"/>">회원가입</a>
				</div>
				<div class="main-find-info">
					<a id="main-find-id" href="<c:url value="/id"/>">아이디 찾기</a>|
					<a id="main-find-password" href="<c:url value="/password"/>">비밀번호 찾기</a>
				</div>
			</div>
		<c:if test="${fail}">
			<div class="form-group"><strong style="color:#ebccd1;">아이디 또는 비밀번호가 틀렸습니다.</strong></div>
		</c:if>
		</form:form>
	</div>
	</session:isGuest>
	<session:isStudent>
	<div class="main-login">
		<img alt="프로필사진" class="main-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
		<h4>어서오세요! 회원님!</h4>
	</div>
	</session:isStudent>
	<session:isManager>
	<div class="main-login">
		<img alt="프로필사진" class="main-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
		<h4>어서오세요! 관리자님!</h4>
		<a class="btn btn-default" href="<c:url value="/stats/join"/>">관리자 페이지</a>
	</div>
	</session:isManager>
</div>