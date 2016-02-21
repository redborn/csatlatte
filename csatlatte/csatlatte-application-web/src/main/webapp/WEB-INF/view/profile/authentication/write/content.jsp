<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form class="form-horizontal" method="post" servletRelativeAction="${url}">
<c:url var="url" value="/<session:id/>/authentication"/>
<div class="profile-authentication">
	<h5><strong>비밀번호 인증</strong></h5>
	<div class="form-group">
		<label class="control-label col-sm-3" for="profile-authentication-content-password">비밀번호</label>
		<div class="col-sm-4"><input id="profile-authentication-content-password" name="password" type="password" class="form-control"></div>
	</div>
	<div class="profile-authentication-message">
		내 정보로 이동하기 위해선 비밀번호를 입력해야 합니다.
	</div>
</div>
<div class="profile-authentication-button-group">
	<a id="profile-authentication-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
	<input id="profile-authentication-btn-success" type="submit" class="btn btn-success" value="다음">
</div>
</form:form>