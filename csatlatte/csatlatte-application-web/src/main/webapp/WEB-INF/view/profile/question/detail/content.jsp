<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<input type="hidden" id="profile-question-detail-qna-sequence" value="${detail.qnaSequence}">
<input type="hidden" id="profile-question-detail-id" value="<session:id/>">
<div class="panel panel-default">
	<div class="panel-body">
		<h5><strong>문의하신 내용</strong></h5>
		<div class="profile-question-detail-content">
			${detail.content}
		</div>
		<h5><strong>답변 내용</strong></h5>
		<div class="profile-question-detail-answer">
			<c:if test="${detail.answerContent eq ''}">관리자가 아직 답변을 작성하지 않았습니다.</c:if>
			${detail.answerContent}
		</div>
	</div>
	<div class="panel-footer">
		<div class="profile-question-detail-footer-content row">
			<div class="profile-question-detail-message col-lg-8">
				<p><strong>원하시는 답이 아닌가요?</strong></p>
				<p>궁금하신 사항이 해결되지 않았다면 다시한번 수능라떼 팀에게 문의해주세요.</p>
			</div>
			<div class="profile-question-detail-btn col-lg-4">
				<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
			</div>
		</div>
	</div>
</div>
<div class="profile-question-detail-btn-group">
	<a class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>/question">목록보기</a>
	<button data-toggle="modal" data-target="#profile-question-detail-delete" class="btn btn-danger" id="profile-question-detail-btn-delete">삭제하기</button>
</div>
<div class="modal fade" id="profile-question-detail-delete" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">문의 삭제하기</h4>
			</div>
			<div class="modal-body">
				<p>문의를 삭제하면 이 문의 대해서는 답변을 받을 수 없습니다.</p>
				<p>정말로 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary" id="profile-question-detail-delete-accept">확인</button>
			</div>
		</div>
	</div>
</div>