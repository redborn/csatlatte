<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4>이 정보는 어디서 사용되나요?</h4>
<p>프로필 사진 및 닉네임은</p>
<p>커뮤니티에서 나타납니다.</p>
<p>당신의 개성을 나타내보세요.</p>
<div id="profile-modify-message">
	<h4>수능을 선택하세요!</h4>
	<p>선택한 수능에 맞게</p>
	<p>성적을 관리하게 됩니다.</p>
</div>
<p id="profile-modify-return"><a href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a></p>
<%@ include file="/WEB-INF/layout/attribute/banner/250x250.jsp" %>