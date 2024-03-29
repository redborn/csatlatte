<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="progress">
	<div class="progress-bar progress-bar-warning progress-first" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		1단계 닉네임 입력
	</div>
	<div class="progress-bar progress-bar-success progress-bar-striped active progress-step" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-warning progress-final" role="progressbar" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100">
		3단계 아이디 찾기 완료
	</div>
</div>
<form:form id="id-security-write-form" method="post" servletRelativeAction="/id/security" class="form-horizontal">
	<div class="id-security-write">
		<h4>보안 확인 <small>회원가입때 등록한 보안 질문과 답변입니다.</small></h4>
		<div class="form-group">
			<label class="col-sm-2 control-label">질문</label>
			<div class="col-sm-7 id-security-write-question">${securityQuestion}</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="id-security-write-content-answer">답변</label>
			<div class="col-sm-7"><input id="id-security-write-content-answer" maxlength="8" name="securityAnswer" type="text" class="form-control"></div>
			<input type="hidden" name="nickname" value="${param.nickname}">
		</div>
	</div>
	<div class="id-security-write-button-group">
		<a class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="id-security-write-btn-success" type="submit" disabled="disabled" class="btn btn-success" value="다음단계">
	</div>
</form:form>