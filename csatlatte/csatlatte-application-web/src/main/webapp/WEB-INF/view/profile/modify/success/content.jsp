<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile-modify-success-message">
	<h4>변경한 정보가 적용되었습니다.</h4>
	혹시 수능을 잘못 선택하진 않으셨겠죠?<br/>
	선택한 수능에 맞춰 다양한 서비스가 제공됩니다.		
</div>
<div class="profile-modify-success-return">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a>
</div>