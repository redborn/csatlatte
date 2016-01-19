<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		1단계 아이디 입력
	</div>
	<div class="progress-bar progress-bar-success progress-step progress-bar-striped active progress-first" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		3단계 새 비밀번호 설정
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		4단계 비밀번호 찾기 완료
	</div>
</div>
<form id="password-security-write-form" class="form-horizontal" method="post" action="<c:url value="/password/security"/>">
	<div class="password-security-write">
		<h4>보안 확인 <small>회원가입때 등록한 보안 질문과 답변입니다.</small></h4>
		<div class="form-group">
			<label class="col-sm-2 control-label">질문</label>
			<div class="col-sm-7 password-security-write-question">${securityQuestion}</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="password-security-write-content-answer">답변</label>
			<div class="col-sm-6"><input maxlength="8" name="securityAnswer" id="password-security-write-content-answer" type="text" class="form-control"></div>
			<input type="hidden" name="studentId" value="${param.studentId}">
		</div>
	</div>
	<div class="password-security-write-button-group">
		<a class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="password-security-write-btn-success" type="submit" class="btn btn-success" value="다음단계">
	</div>
</form>