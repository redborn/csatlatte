<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-password-success-message">
	<h4>비밀번호 변경이 완료되었습니다.</h4>
	다음 로그인부터 변경한 비밀번호가 적용됩니다.
</div>
<div class="profile-password-success-return">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a>
</div>