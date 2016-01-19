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
<form id="password-new-write-form" class="form-horizontal" method="post" action="<c:url value="/password/new"/>">
	<div class="password-new-write">
		<h4>보안 확인이 완료되었습니다. <small>새 비밀번호를 설정해주세요.</small></h4>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="password-new-write-password">비밀번호</label>
			<div class="col-sm-5"><input id="password-new-write-password" type="password" class="form-control"></div>
			<div class="col-sm-5"><div id="password-new-write-message-area"></div></div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="password-new-write-password-check">비밀번호 확인</label>
			<div class="col-sm-5"><input id="password-new-write-password-check" name="newPassword" type="password" class="form-control"></div>
			<div class="col-sm-5"><div id="password-new-write-check-message-area"></div></div>
			<input type="hidden" name="studentId" value="${param.studentId}">
			<input type="hidden" name="securityAnswer" value="${param.securityAnswer}">
		</div>
	</div>
	<div class="password-new-write-button-group">
		<a class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="password-new-write-btn-success" type="submit" class="btn btn-success" value="다음단계">
	</div>
</form>