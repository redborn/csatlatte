<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="profile">
	<div class="profile-id">
		<h5><strong>수능라떼 아이디 및 비밀번호</strong></h5>
		<div class="profile-content">
			<label>아이디</label>
			<div class="profile-content-value"><session:id/></div>
		</div>
		<div class="profile-message">
			<a href="${pageContext.request.contextPath}/<session:id/>/password">비밀번호 변경하기</a>
		</div>
	</div>
	<div class="profile-security">
		<h5><strong>보안 질문</strong> <small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h5>
		<div class="profile-content">
			<label>질문</label>
			<div class="profile-content-value">${securityQuestion}</div>
		</div>
		<div class="profile-message">
			<a href="${pageContext.request.contextPath}/<session:id/>/authentication">보안질문 변경하기</a>
		</div>
	</div>
	<div class="profile-info">
		<h5><strong>프로필 사진 및 닉네임</strong> <small>커뮤니티를 이용 시에 사용되는 정보입니다.</small></h5>
		<div class="profile-content">
			<label>프로필 사진</label>
			<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
		</div>
		<div class="profile-content">
			<label id="profile-for-align">닉네임</label>
			<div class="profile-content-value"><session:nickname/></div>
		</div>
		<div class="profile-content">
			<label>수능</label>
			<div class="profile-content-value">${csat.csatName}</div>
		</div>
		<div class="profile-message">
			<a href="${pageContext.request.contextPath}/<session:id/>/modify">정보 변경하기</a>
		</div>
	</div>
</div>