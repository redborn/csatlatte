<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-password-fail-message">
	<h4>비밀번호 변경을 실패했습니다.</h4>
	비밀번호가 올바르지 않습니다.<br/>
	로그인할때 작성한 비밀번호를 입력해주세요.
</div>
<div class="profile-password-fail-return">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a>
</div>