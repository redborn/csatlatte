<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-danger progress-bar-striped active progress-first" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
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
<div class="password-write">
	<h5>비밀번호 찾기에 실패했습니다.</h5>
	<p>입력하신 아이디가 존재하지 않습니다.</p>
	<p>다시 시도하시려면 우측 하단의 버튼을 클릭해주세요.</p>
</div>
<div id="password-write-btn-group">
	<a id="password-write-btn-cancel" class="btn btn-default" href="<c:url value="/password"/>">처음으로 돌아가기</a>
</div>