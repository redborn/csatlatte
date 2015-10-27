<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="myinfo-authentication-fail-message">
	<h4>비밀번호 인증을 실패했습니다.</h4>
	비밀번호가 올바르지 않습니다.<br/>
	로그인할때 작성한 비밀번호를 입력해주세요.	
</div>
<div class="myinfo-authentication-fail-return">
	<a class="btn btn-default" href="<c:url value="/myinfo/authentication"/>">다시 시도하기</a>
</div>