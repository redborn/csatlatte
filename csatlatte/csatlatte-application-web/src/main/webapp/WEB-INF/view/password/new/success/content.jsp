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
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		3단계 새 비밀번호 설정
	</div>
	<div class="progress-bar progress-bar-success progress-step progress-bar-striped active progress-first" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
		4단계 비밀번호 찾기 완료
	</div>
</div>
<div class="password-new-success">
	<h5>비밀번호 변경이 완료되었습니다.</h5>
	<p>로그인 하시려면 우측 하단 버튼을 클릭해주세요.</p>
</div>
<div class="password-new-success-button-group">
	<a id="password-new-success-btn-success" class="btn btn-default" href="<c:url value="/main"/>">로그인 하기</a>
</div>