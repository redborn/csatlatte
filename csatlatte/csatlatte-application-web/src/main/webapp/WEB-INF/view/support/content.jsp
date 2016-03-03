<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div class="col-lg-12 support-col-lg">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>환영합니다.<br/><small>궁금하신 사항을 아래 분류를 선택하면 쉽게 찾을 수 있습니다.</small><br/></h4>
		</div>
		<div class="panel-body" id="support-content">
		<c:forEach items="${list}" var="faq">
			<div class="support-faq">
				<div class="support-question"><p><strong>${faq.title}</strong></p></div>
				<div class="support-answer">${faq.content}</div>
			</div>
		</c:forEach>
		</div>
		<div class="panel-footer">
			<div class="row support-guide">
				<div class="col-sm-9 support-guide-message">
					<session:isGuest>
						<strong>필요한 답을 얻지 못했나요?</strong><br/>
						수능라떼팀에게 문의하려면 우선 회원가입을 진행해야 합니다.
					</session:isGuest>
					<session:isStudent>
						<strong>필요한 답을 얻지 못했나요?</strong><br/>
						궁금한 항목에 대한 정보를 찾지 못했다면 수능라떼팀으로 문의해주세요.
					</session:isStudent>
					<session:isManager>
						<strong>회원들의 문의를 확인하셨나요?</strong><br />
						문의에 대한 답변을 진행하려면 관리자 메뉴로 이동해야 합니다.
					</session:isManager>
				</div>
				<div class="col-sm-3 support-btn-align-right">
					<session:isGuest>
						<a class="btn btn-default" href="<c:url value="/join"/>">가입하기</a>
					</session:isGuest>
					<session:isStudent>
						<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
					</session:isStudent>
					<session:isManager>
						<a class="btn btn-default" href="<c:url value="/manage/question"/>">답변하기</a>
					</session:isManager>
				</div>
			</div>
		</div>
	</div>
</div>