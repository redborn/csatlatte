<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		1단계 닉네임 입력
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-success progress-bar-striped active progress-final" role="progressbar" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100">
		3단계 아이디 찾기 완료
	</div>
</div>
<div class="id-security-success">
	<div>
		<h4>아이디를 찾았습니다.</h4>
		<div class="id-security-success-content">
			<label id="id-security-label">아이디</label>
			<div id="id-security-result">${id}</div>
		</div>
	</div>
	<div>
		<h4>혹시 비밀번호도 분실하셨나요?</h4>
		<div class="id-security-success-message">
			<a href="<c:url value="/password"/>">비밀번호 찾기</a>
		</div>
	</div>
</div>
<div class="id-security-success-button-group">
	<a class="btn btn-primary" href="<c:url value="/main"/>">로그인 하기</a>
</div>