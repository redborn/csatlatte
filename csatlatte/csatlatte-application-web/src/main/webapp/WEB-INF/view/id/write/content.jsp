<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="progress">
	<div class="progress-bar progress-bar-success progress-bar-striped active progress-first" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		1단계 닉네임 입력
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-warning progress-final" role="progressbar" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100">
		3단계 아이디 찾기 완료
	</div>
</div>
<form method="post" action="<c:url value="/id"/>">
	<div class="id-write">
		<h5>아이디 정보</h5>
		<div class="id-write-content">
			<label for="id-write-content-nickname">닉네임</label>
			<input id="id-write-content-nickname" type="text" class="form-control">
		</div>
	</div>
	<div class="id-write-button-group">
		<a id="id-write-btn-cancel" class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="id-write-btn-success" type="submit" class="btn btn-default" value="다음단계">
	</div>
</form>