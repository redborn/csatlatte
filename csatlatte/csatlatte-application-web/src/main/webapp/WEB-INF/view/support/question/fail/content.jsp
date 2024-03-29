<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-default col-lg-12">
	<div class="panel-body">
		<div class="support-question-fail">
			<h4>문의를 전달하지 못했습니다.</h4>
			<div class="support-question-fail-message">
				<p>문의내용을 수능라떼팀에게 전달하지 못했습니다.</p>
				<p>이전 페이지로 돌아가 문의를 다시 시도하실 수 있습니다.</p><br/>
				<p>문의를 다시 시도하시려면 웹브라우저의 뒤로가기 버튼이나 우측 하단의 버튼을 누르시면 됩니다.</p><br/>
			</div>
			<div class="support-question-fail-retry-quesiton">
				<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
			</div>
		</div>
	</div>
</div>