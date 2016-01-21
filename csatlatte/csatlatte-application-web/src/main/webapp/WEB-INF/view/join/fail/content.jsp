<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="join-fail">
	<div>
		<h4>회원가입을 실패했습니다.</h4>
		<p>회원가입 처리 중 문제가 있었던 것으로 보입니다.</p>
		<p>우측 하단의 버튼을 눌러 회원가입을 재시도하시기 바랍니다.</p>
	</div>
</div>
<div id="join-fail-btn-group">
	<a class="btn btn-danger" href="<c:url value="/join"/>">다시 가입하기</a>
</div>