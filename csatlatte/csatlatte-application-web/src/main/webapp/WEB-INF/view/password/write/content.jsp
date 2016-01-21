<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-success progress-bar-striped active progress-first" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		1단계 아이디 입력
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		3단계 새 비밀번호 설정
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		4단계 비밀번호 찾기 완료
	</div>
</div>
<form id="password-write-form" class="form-horizontal" method="post" action="<c:url value="/password"/>">
	<div class="password-write">
		<h4>아이디 정보</h4>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="password-write-content-id">아이디</label>
			<div class="col-sm-6"><input maxlength="10" id="password-write-content-id" name="studentId" type="text" class="form-control"></div>
		</div>
	</div>
	<div class="password-write-button-group">
		<a class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="password-write-btn-success" type="submit" disabled="disabled" class="btn btn-success" value="다음단계">
	</div>
</form>