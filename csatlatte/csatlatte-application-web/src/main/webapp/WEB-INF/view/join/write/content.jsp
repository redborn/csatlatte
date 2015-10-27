<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<form method="post" action="<c:url value="/join"/>">
	<div class="join">
		<div class="join-id">
			<h5>수능라떼 아이디 정보</h5>
			<div class="join-content">
				<label for="join-content-id">아이디</label>
				<input id="join-content-id" type="text" class="form-control">
			</div>
			<div class="join-content">
				<label for="join-content-password">비밀번호</label>
				<input id="join-content-password" type="password" class="form-control">
			</div>
			<div class="join-content">
				<label for="join-content-password-check">비밀번호 확인</label>
				<input id="join-content-password-check" type="password" class="form-control">
			</div>
		</div>
		<div class="join-security">
			<h5>보안 질문 <small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h5>
			<div class="join-content">	
				<label for="join-content-select-question">질문 선택</label>
				<select id="join-content-select-question" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
			<div class="join-content">
				<label for="join-content-answer">답변</label>
				<input id="join-content-answer" type="text" class="form-control">
			</div>
		</div>
		<div class="join-info">
			<h5>프로필 사진 및 닉네임 <small>커뮤니티를 이용 시에 사용되는 정보입니다.</small></h5>
			<div class="join-content">
				<label id="join-profile-picture">프로필 사진</label>
				<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
			</div>
			<div class="join-content">
				<label for="join-content-nickname">닉네임</label>
				<input id="join-content-nickname" type="text" class="form-control">
			</div>
			<div class="join-content">
				<label for="join-content-select-sat">수능 선택</label>
				<select id="join-content-select-sat" class="form-control">
					<option>2016학년도 대학수학능력시험 (현재 3학년 / N수생)</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
			<div class="join-message">
				<label for="join-content-select-sat">선택한 수능에 맞게 모의고사 등급컷, 내 성적 관리 서비스가 제공됩니다.</label>
			</div>
		</div>
	</div>
	<div class="join-button-group">
		<a id="join-btn-cancel" class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="join-btn-success" type="submit" class="btn btn-default" value="계정 만들기">
	</div>
</form>