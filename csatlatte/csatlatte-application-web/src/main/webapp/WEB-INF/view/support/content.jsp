<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="col-lg-12 support-col-lg">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>환영합니다.<br/><small>궁금하신 사항을 아래 분류를 선택하면 쉽게 찾을 수 있습니다.</small><br/></h4>
			<div class="col-lg-3 support-col-lg">
				<select id="support-category" class="form-control">
					<c:forEach items="${typeList}" var="type">
						<option value="${type.typeSequence}" <c:if test="${param.faqTypeSequence eq type.typeSequence}">selected</c:if>>${type.description}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="panel-body" id="support-content">
			<c:forEach items="${list}" var="list">
				<div class="support-faq">
					<div class="support-question"><p><strong>${list.title}</strong></p></div>
					<div class="support-answer">${list.content}</div>
				</div>
			</c:forEach>
		</div>
		<div class="panel-footer">
			<div class="row support-guide">
				<div class="col-lg-8 support-guide-message">
					<strong>필요한 답을 얻지 못했나요?</strong><br/>
					궁금한 항목에 대한 정보를 찾지 못했다면 수능라떼팀으로 문의해주세요.
				</div>
				<div class="col-lg-4 support-btn-align-right">
					<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
				</div>
			</div>
		</div>
	</div>
</div>