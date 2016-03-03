<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="join-success">
	<div>
		<h4>회원가입이 완료되었습니다!</h4>
		<p>수능라떼의 가족이 되신 것을 환영합니다.</p>
		<p>등록하신 아이디와 비밀번호로 수능라떼 서비스를 이용하실 수 있습니다.</p>
	</div>
	<div>
		<p>서비스 이용방법이 궁금하신가요?</p>
		<a id="join-success-message" href="<c:url value="/support"/>">수능라떼 고객지원 보기</a>
	</div>
</div>
<div id="join-success-btn-group">
	<a class="btn btn-default" href="<c:url value="/main"/>">로그인 하기</a>
</div>