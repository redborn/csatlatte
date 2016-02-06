<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4><strong>수능라떼 비밀번호 변경</strong></h4>
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/<session:id/>/password">
	<div class="form-group">
		<label for="profile-password-content-before" class="control-label col-sm-3">기존 비밀번호</label>
		<div class="col-sm-5">
			<input id="profile-password-content-before" type="password" class="form-control" placeholder="기존 비밀번호"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2">비밀번호 혹은 보안질문을 변경하는 경우 반드시 입력하셔야 합니다.</div>
	</div>
	<div class="form-group">
		<label for="profile-password-content-new" class="control-label col-sm-3">새 비밀번호</label>
		<div class="col-sm-5">
			<input id="profile-password-content-new" type="password" class="form-control" placeholder="새 비밀번호"/>
		</div>
	</div>
	<div class="form-group">
		<label for="profile-password-content-new-check" class="control-label col-sm-3">새 비밀번호 확인</label>
		<div class="col-sm-5">
			<input id="profile-password-content-new-check" type="password" class="form-control" placeholder="새 비밀번호 확인"/>
		</div>
	</div>
	<div class="profile-password-button-group">
		<a id="profile-password-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
		<input id="profile-password-btn-success" type="submit" class="btn btn-default" value="변경 완료">
	</div>
</form>