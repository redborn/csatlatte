<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		1단계 아이디 입력
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-success progress-step progress-bar-striped active progress-first" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		3단계 새 비밀번호 설정
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		4단계 비밀번호 찾기 완료
	</div>
</div>
<form method="post" action="<c:url value="/password/new"/>">
	<div class="password-new-write">
		<h5>보안 확인이 완료되었습니다.</h5>
		<div class="password-new-write-value">새 비밀번호를 설정해주세요.</div>
		<div class="password-new-write-content">
			<label for="password-new-write-password">비밀번호</label>
			<input id="password-new-write-password" type="text" class="form-control">
		</div>
		<div class="password-new-write-content">
			<label for="password-new-write-password-confirm">비밀번호 확인</label>
			<input id="password-new-write-password-confirm" type="text" class="form-control">
		</div>
	</div>
	<div class="password-new-write-button-group">
		<a id="password-new-write-btn-cancel" class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="password-new-write-btn-success" type="submit" class="btn btn-default" value="다음단계">
	</div>
</form>