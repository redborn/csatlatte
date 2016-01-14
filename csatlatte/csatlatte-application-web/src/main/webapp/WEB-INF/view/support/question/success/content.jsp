<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-default col-lg-12">
	<div class="panel-body">
		<div class="support-question-success">
			<h4>문의가 성공적으로 전달되었습니다.</h4>
			<div class="support-question-success-message">
				<p>문의내용 및 답변은 우측 상단에 내 정보에서 확인하실 수 있습니다.</p>
				<p>우측 하단의 버튼을 통해 즉시 문의내역 페이지로 이동하실 수 있습니다.</p><br/>
				<p>문의하신 내용은 서비스 개선을 위해 수능라떼팀이 보관합니다.</p>
				<p>명확하지 않은 질문에 대해선 올바른 답변이 어려울 수 있습니다.</p><br/>
				<p>문의에 대한 답변을 받기 이전까지 문의하신 사항을 내 정보에서 문의내역 삭제를 통하여 문의를 취소하실 수 있습니다.</p><br/>
			</div>
			<div class="support-question-success-view-quesiton">
				<a class="btn btn-default" href="<c:url value="/myinfo/question"/>">문의내역 보기</a>
			</div>
		</div>
	</div>
</div>