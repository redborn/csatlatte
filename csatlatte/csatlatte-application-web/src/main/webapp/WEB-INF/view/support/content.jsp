<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="panel panel-default">
	<div class="panel-heading">
		<h4>환영합니다.<br/><small>궁금하신 사항을 아래 분류를 선택하면 쉽게 찾을 수 있습니다.</small><br/></h4>
		<select id="support-category" class="form-control">
			<c:forEach items="${typeList}" var="type">
				<option value="${type.typeSequence}" <c:if test="${param.faqTypeSequence eq type.typeSequence}">selected</c:if>>${type.description}</option>
			</c:forEach>
		</select>
	</div>
	<div class="panel-body">
		<c:forEach items="${list}" var="list">
			<div class="support-question"><p><strong>${list.title}</strong></p></div>
			<div class="support-answer">${list.content}</div>
		</c:forEach>
	</div>
	<div class="panel-footer">
		<div class="support-guide">
			<session:isGuest>
				<div class="support-guide-message">
					<p><strong>필요한 답을 얻지 못했나요?</strong></p>
					수능라떼팀에게 문의하려면 우선 회원가입을 진행해야 합니다.
				</div>
				
				<div class="support-btn-align-right">
					<a class="btn btn-default" href="<c:url value="/join"/>">회원가입 하기</a>
				</div>
			</session:isGuest>
			<session:isStudent>
				<div class="support-guide-message">
					<p><strong>필요한 답을 얻지 못했나요?</strong></p>
					궁금한 항목에 대한 정보를 찾지 못했다면 수능라떼팀으로 문의해주세요.
				</div>
				
				<div class="support-btn-align-right">
					<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
				</div>
			</session:isStudent>
			<session:isAdministrator>
				<div class="support-guide-message">
					<p><strong>회원들의 문의를 확인하셨나요?</strong></p>
					문의에 대한 답변을 진행하려면 관리자 메뉴로 이동해야 합니다.
				</div>
				
				<div class="support-btn-align-right">
					<a class="btn btn-default" href="<c:url value="/manage/question"/>">문의내역 보기</a>
				</div>
			</session:isAdministrator>
		</div>
	</div>
</div>