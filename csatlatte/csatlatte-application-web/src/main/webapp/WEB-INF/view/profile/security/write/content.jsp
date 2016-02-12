<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h5><strong>보안 질문</strong>&nbsp;<small>아이디 혹은 비밀번호를 분실한 경우 필요한 정보입니다.</small></h5>
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/<session:id/>/security">
	<div class="form-group">
		<label for="profile-security-question" class="control-label col-sm-2">질문 선택</label>
		<div class="col-sm-7">
			<select id="profile-security-question" name="securityQuestionSequence" class="form-control">
				<c:forEach items="${securityQuestionList}" var="securityQuestion">
					<option value="${securityQuestion.securityQuestionSequence}">${securityQuestion.content}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="profile-security-answer" class="control-label col-sm-2">답변</label>
		<div class="col-sm-5"><input id="profile-security-answer" maxlength="8" type="text" name="answer" class="form-control" placeholder="답변"/></div>
		<div class="col-sm-5"><div id="profile-security-answer-message-area"></div></div>
	</div>
	<div class="profile-security-button-group">
		<a id="profile-security-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
		<input id="profile-security-btn-success" type="submit" class="btn btn-primary" value="변경 완료">
	</div>
</form>