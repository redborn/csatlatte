<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h5><strong>수능라떼 비밀번호 변경</strong></h5>
<form:form class="form-horizontal" method="post" servletRelativeAction="/${studentId}/password">
	<div class="form-group">
		<label for="profile-before-password" class="control-label col-sm-3">기존 비밀번호</label>
		<div class="col-sm-4"><input maxlength="15" name="beforePassword" id="profile-before-password" type="password" class="form-control" placeholder="기존 비밀번호"/></div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2">비밀번호 혹은 보안질문을 변경하는 경우 반드시 입력하셔야 합니다.</div>
	</div>
	<div class="form-group">
		<label for="profile-password" class="control-label col-sm-3">새 비밀번호</label>
		<div class="col-sm-4"><input maxlength="15" name="newPassword" id="profile-password" type="password" class="form-control" placeholder="새 비밀번호"/></div>
		<div class="col-sm-5"><div id="profile-password-message-area"></div></div>
	</div>
	<div class="form-group">
		<label for="profile-password-check" class="control-label col-sm-3">새 비밀번호 확인</label>
		<div class="col-sm-4"><input maxlength="15" name="newPasswordCheck" id="profile-password-check" type="password" class="form-control" placeholder="새 비밀번호 확인"/></div>
		<div class="col-sm-5"><div id="profile-password-check-message-area"></div></div>
	</div>
	<div class="profile-password-button-group">
		<a id="profile-password-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
		<input id="profile-password-btn-success" type="submit" class="btn btn-primary" value="변경 완료">
	</div>
</form:form>