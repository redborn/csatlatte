<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="myinfo-authentication">
	<h5>수능라떼 비밀번호</h5>
	<div class="myinfo-authentication-content">
		<label for="myinfo-authentication-content-password">비밀번호</label>
		<input id="myinfo-authentication-content-password" type="text" class="form-control">
	</div>
	<div class="myinfo-authentication-message">
		내 정보로 이동하기 위해선 비밀번호를 입력해야 합니다.
	</div>
</div>
<div class="myinfo-authentication-button-group">
	<a id="myinfo-authentication-btn-cancel" class="btn btn-default" href="<c:url value="/main"/>">취소</a>
	<form method="POST" action="<c:url value="/myinfo/authentication"/>">
		<input id="myinfo-authentication-btn-success" type="submit" class="btn btn-default" value="확인">
	</form>
</div>