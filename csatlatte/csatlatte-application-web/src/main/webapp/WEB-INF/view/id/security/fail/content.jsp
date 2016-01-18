<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-warning progress-first" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		1단계 닉네임 입력
	</div>
	<div class="progress-bar progress-bar-danger progress-bar-striped active progress-step" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-warning progress-final" role="progressbar" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100">
		3단계 아이디 찾기 완료
	</div>
</div>
<div class="id-security-fail">
	<h4>아이디를 찾지 못했습니다.</h4>
	<p>찾으려는 아이디의 보안 답변이 올바르지 않습니다.</p>
	<p>다시 시도하시려면 우측 하단의 버튼을 클릭해주세요.</p>
</div>
<div id="id-security-fail-btn-group">
	<a class="btn btn-danger" href="<c:url value="/id"/>">처음으로 돌아가기</a>
</div>