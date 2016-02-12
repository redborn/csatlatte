<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-security-fail-message">
	<h4>보안 질문 변경을 실패했습니다.</h4>
	실패한 경우에는 여러가지 원인이 있을 수 있습니다.<br/>
	인터넷 상태가 원활한지 확인하신 후 다시 시도해보세요.		
</div>
<div class="profile-security-fail-return">
	<a class="btn btn-default" href="<c:url value="/myinfo"/>">내 정보로 돌아가기</a>
</div>