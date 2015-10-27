<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="myinfo">
	<div class="myinfo-id">
		<h5>수능라떼 아이디 및 비밀번호</h5>
		<div class="myinfo-content">
			<label>아이디</label>
			<div class="myinfo-content-value">test1234</div>
		</div>
		<div class="myinfo-message">
			<a href="<c:url value="/myinfo/password"/>">비밀번호 변경하기</a>
		</div>
	</div>
	<div class="myinfo-security">
		<h5>보안 질문 <small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h5>
		<div class="myinfo-content">
			<label>질문</label>
			<div class="myinfo-content-value">출신 초등학교가 어디인가요?</div>
		</div>
		<div class="myinfo-message">
			<a href="<c:url value="/myinfo/security"/>">보안질문 변경하기</a>
		</div>
	</div>
	<div class="myinfo-profile">
		<h5>프로필 사진 및 닉네임 <small>커뮤니티를 이용 시에 사용되는 정보입니다.</small></h5>
		<div class="myinfo-content">
			<label>프로필 사진</label>
			<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
		</div>
		<div class="myinfo-content">
			<label id="myinfo-for-align">닉네임</label>
			<div class="myinfo-content-value">테스트</div>
		</div>
		<div class="myinfo-content">
			<label>수능</label>
			<div class="myinfo-content-value">2016학년도 대학수학능력시험 (현재 3학년 / N수생)</div>
		</div>
		<div class="myinfo-message">
			<a href="<c:url value="/myinfo/modify"/>">정보 변경하기</a>
		</div>
	</div>
</div>