<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-security-fail-message">
	<h4>보안 질문 변경을 실패했습니다.</h4>
	보안 답변 설정이 올바르지 않습니다.<br/>
	다시한번 시도해주시기 바랍니다.		
</div>
<div class="profile-security-fail-return">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a>
</div>