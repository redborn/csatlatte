<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="join-write-form" method="POST" action="<c:url value="/join"/>">
	<div class="join">
		<div class="join-id">
			<h5>수능라떼 아이디 정보</h5>
			<div class="join-content">
				<label for="join-content-id">아이디</label>
				<input id="join-content-id" maxlength="10" data-toggle="tooltip-id" data-placement="right" title="아이디가 올바르지 않습니다." type="text" class="form-control">
				<div id="join-id-check-message-area"></div>
			</div>
			<div class="join-content">
				<label for="join-content-password">비밀번호</label>
				<input id="join-content-password" maxlength="15" data-toggle="tooltip-password" data-placement="right" title="비밀번호가 올바르지 않습니다." type="password" class="form-control">
				<div id="join-password-message-area"></div>
			</div>
			<div class="join-content">
				<label for="join-content-password-check">비밀번호 확인</label>
				<input id="join-content-password-check" data-toggle="tooltip-password-check" data-placement="right" title="비밀번호가 일치하지 않습니다." type="password" class="form-control">
				<div id="join-password-check-message-area"></div>
			</div>
		</div>
		<div class="join-security">
			<h5>보안 질문 <small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h5>
			<div class="join-content">	
				<label for="join-content-select-question">질문 선택</label>
				<select id="join-content-select-question" class="form-control">
					<c:forEach items="${securityQuestionList}" var="securityQuestion">
						<option value="${securityQuestion.securityQuestionSequence}">${securityQuestion.content}</option>
					</c:forEach>
				</select>
			</div>
			<div class="join-content">
				<label for="join-content-answer">답변</label>
				<input id="join-content-answer" maxlength="8" data-toggle="tooltip-answer" data-placement="right" title="답변이 올바르지 않습니다." type="text" class="form-control">
				<div id="join-answer-check-message-area"></div>
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
				<input id="join-content-nickname" maxlength="8" data-toggle="tooltip-nickname" data-placement="right" title="닉네임이 올바르지 않습니다." type="text" class="form-control">
				<div id="join-nickname-check-message-area"></div>
			</div>
			<div class="join-content">
				<label for="join-content-select-sat">수능 선택</label>
				<select id="join-content-select-sat" class="form-control">
					<c:forEach items="${yearList}" var="year">
						<option value="${year.csatSequence}">${year.csatName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="join-message">
				선택한 수능에 맞게 모의고사 등급컷, 내 성적 관리 서비스가 제공됩니다.
			</div>
		</div>
	</div>
	<div class="join-button-group">
		<a id="join-btn-cancel" class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="join-btn-success" type="submit" class="btn btn-default" value="계정 만들기">
	</div>
</form>