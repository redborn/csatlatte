<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div id="myinfo-message1">
	<h4>이 정보가 맞나요?</h4>
	<p>회원가입 할 때 입력했던 정보입니다.</p>
	<p>잘못된 사항이나 수정하고 싶은 사항은</p>
	<p>얼마든지 변경이 가능합니다.</p>
</div>
<div id="myinfo-message2">
	<h4>문의하신 사항이 있으신가요?</h4>
	<p>고객센터에서 수능라떼 팀에게</p>
	<p>문의하신 사항에 대한 답변을</p>
	<p>확인할 수 있습니다.</p>
</div>
<p id="myinfo-question"><a href="<c:url value="/myinfo/question"/>">문의내역 보기</a></p>