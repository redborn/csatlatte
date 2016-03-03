<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-security-success-message">
	<h4>보안 질문이 변경되었습니다.</h4>
	아이디 또는 비밀번호를 분실한 경우 변경하신 답변으로 찾으실 수 있습니다.		
</div>
<div class="profile-security-success-return">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a>
</div>