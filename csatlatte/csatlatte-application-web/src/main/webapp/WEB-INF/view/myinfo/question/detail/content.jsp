<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="panel panel-default">
	<div class="panel-body">
		<h5><strong>문의 제목 :</strong> 여기는 문의 제목입니다.</h5>
		<h5><strong>문의하신 내용</strong></h5>
		<div class="myinfo-question-detail-content">
			내용
		</div>
		<h5><strong>답변 내용</strong></h5>
		<div class="myinfo-question-detail-answer">
			답변 내용
		</div>
	</div>
	<div class="panel-footer">
		<div class="myinfo-question-detail-message">
			<p><strong>원하시는 답이 아닌가요?</strong></p>
			<p>궁금하신 사항이 해결되지 않았다면 다시한번 수능라떼 팀에게 문의해주세요.</p>
		</div>
		<div class="myinfo-question-detail-btn">
			<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
		</div>
	</div>
</div>
<div class="myinfo-question-detail-btn-group">
	<a class="btn btn-default" href="<c:url value="/myinfo/question"/>">목록보기</a>
	<input type="submit" class="btn btn-default" id="myinfo-question-detail-btn-delete" value="삭제하기">
</div>