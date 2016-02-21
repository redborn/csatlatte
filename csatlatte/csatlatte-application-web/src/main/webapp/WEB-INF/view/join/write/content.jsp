<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="join-write-form" method="post" servletRelativeAction="/join" class="form-horizontal" enctype="multipart/form-data">
	<div class="join">
		<h4>수능라떼 아이디 정보</h4>
		<div class="join-id">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="join-content-id">아이디</label>
				<div class="col-sm-5"><input name="studentId" id="join-content-id" maxlength="10" data-toggle="tooltip-id" data-placement="right" title="아이디가 올바르지 않습니다." type="text" class="form-control"></div>
				<div class="col-sm-5"><div id="join-id-check-message-area"></div></div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="join-content-password">비밀번호</label>
				<div class="col-sm-5"><input name="password" id="join-content-password" maxlength="15" data-toggle="tooltip-password" data-placement="right" title="비밀번호가 올바르지 않습니다." type="password" class="form-control"></div>
				<div class="col-sm-5"><div id="join-password-message-area"></div></div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="join-content-password-check">비밀번호 확인</label>
				<div class="col-sm-5"><input id="join-content-password-check" data-toggle="tooltip-password-check" data-placement="right" title="비밀번호가 일치하지 않습니다." type="password" class="form-control"></div>
				<div class="col-sm-5"><div id="join-password-check-message-area"></div></div>
			</div>
		</div>
		<h4>보안 질문 <small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h4>
		<div class="join-security">
			<div class="form-group">	
				<label class="col-sm-2 control-label" for="join-content-select-question">질문 선택</label>
				<div class="col-sm-7">
					<select name="securityQuestion" id="join-content-select-question" class="form-control">
						<c:forEach items="${securityQuestionList}" var="securityQuestion">
							<option value="${securityQuestion.securityQuestionSequence}">${securityQuestion.content}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="join-content-answer">답변</label>
				<div class="col-sm-5"><input name="answer" id="join-content-answer" maxlength="8" data-toggle="tooltip-answer" data-placement="right" title="답변이 올바르지 않습니다." type="text" class="form-control"></div>
				<div class="col-sm-5"><div id="join-answer-check-message-area"></div></div>
			</div>
		</div>
		<h4>프로필 사진 및 닉네임 <small>커뮤니티를 이용 시에 사용되는 정보입니다.</small></h4>
		<div class="join-info">
			<div class="form-group">
				<label class="col-sm-2 control-label" id="join-profile-picture">프로필 사진</label>
				<img class="join-image" alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
				<input type="file" name="photo"/>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="join-content-nickname">닉네임</label>
				<div class="col-sm-5"><input name="nickname" id="join-content-nickname" maxlength="8" data-toggle="tooltip-nickname" data-placement="right" title="닉네임이 올바르지 않습니다." type="text" class="form-control"></div>
				<div class="col-sm-5"><div id="join-nickname-check-message-area"></div></div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="join-content-select-sat">수능 선택</label>
				<div class="col-sm-6">
					<select name="csat" id="join-content-select-sat" class="form-control">
						<c:forEach items="${csatList}" var="csat">
							<option value="${csat.csatSequence}"<c:if test="${csat.csatSequence eq presentCsatSequence}"> selected</c:if>>${csat.csatName} (${fn:substring(csat.examYmd, 0, 4)}년 실시)</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="join-message">
				선택한 수능에 맞게 모의고사 등급컷, 내 성적 관리 서비스가 제공됩니다.
			</div>
		</div>
	</div>
	<div class="join-button-group">
		<a class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="join-btn-success" type="submit" class="btn btn-primary" value="계정 만들기">
	</div>
</form:form>