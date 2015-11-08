<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main-picture">
	<div class="main-title">"미래를 위한<br/>현명한 준비"</div>
	<div class="main-login">
	<c:choose>
		<c:when test="${param.key == 'ABC'}">
			<img alt="프로필사진" class="main-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
			<h4>어서오세요! 관리자님!</h4>
			<a class="btn btn-default" href="<c:url value="/stats/join"/>">관리자 페이지</a>
		</c:when>
		<c:when test="${param.key == '123'}">
			<img alt="프로필사진" class="main-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
			<h4>어서오세요! 회원님!</h4>
		</c:when>
		<c:otherwise>
			<form method="post" action='<c:url value="/login"/>'>
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
			</form>
		</c:otherwise>
	</c:choose>
	</div>
</div>