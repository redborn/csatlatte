<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="join-fail">
	<div>
		<h4>회원가입을 실패했습니다.</h4>
		<p>죄송합니다. 회원가입을 진행하는 중에 문제가 발생했습니다.</p>
		<p>이 문제는 다양한 상황에 의해 발생할 수 있습니다.</p>
		<p>수능라떼의 회원이 되시기 위해서는 가입을 다시 시도하는 방법이 있습니다.</p>
		<p>우측 하단의 버튼을 눌러 회원가입을 재시도하시기 바랍니다.</p>
	</div>
</div>
<div id="join-fail-btn-group">
	<a class="btn btn-danger" href="<c:url value="/join"/>">다시 가입하기</a>
</div>