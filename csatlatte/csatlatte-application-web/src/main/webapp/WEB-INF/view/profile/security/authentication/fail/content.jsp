<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-authentication-fail-message">
	<h4>비밀번호 인증에 실패했습니다.</h4>
	비밀번호가 올바르지 않습니다.<br/>
	로그인 시 입력한 비밀번호를 입력하세요.	
</div>
<div class="profile-authentication-fail-return">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>/security/authentication">다시 시도하기</a>
</div>