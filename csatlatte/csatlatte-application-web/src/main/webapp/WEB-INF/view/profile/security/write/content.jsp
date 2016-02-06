<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4><strong>보안 질문</strong>&nbsp;<small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h4>
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/<session:id/>/security">
	<div class="form-group">
		<label for="profile-security-question" class="control-label col-sm-3">질문 선택</label>
		<div class="col-sm-5">
			<select id="profile-security-question" class="form-control">
				<option>출신 고등학교가 어디인가요?</option>
				<option>....</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="profile-security-content-answer" class="control-label col-sm-3">답변</label>
		<div class="col-sm-5">
			<input id="profile-security-content-answer" type="password" class="form-control" placeholder="답변"/>
		</div>
	</div>
	<div class="profile-security-button-group">
		<a id="profile-security-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
		<input id="profile-security-btn-success" type="submit" class="btn btn-default" value="변경 완료">
	</div>
</form>