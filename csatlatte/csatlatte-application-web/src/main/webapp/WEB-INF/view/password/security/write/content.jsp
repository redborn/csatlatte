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
<form method="post" action="<c:url value="/password/security"/>">
	<div class="password-security-write">
		<h5>보안 확인 <small>회원가입때 등록한 보안 질문과 답변입니다.</small></h5>
		<div class="password-security-write-content">
			<label>질문</label>
			<div class="password-security-write-content-value">당신의 어린시절 가장 기억에 남는 일은 무엇인가요?</div>
		</div>
		<div class="password-security-write-content">
			<label for="password-security-write-content-answer">답변</label>
			<input id="password-security-write-content-answer" type="text" class="form-control">
		</div>
	</div>
	<div class="password-security-write-button-group">
		<a id="password-security-write-btn-cancel" class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="password-security-write-btn-success" type="submit" class="btn btn-default" value="다음단계">
	</div>
</form>