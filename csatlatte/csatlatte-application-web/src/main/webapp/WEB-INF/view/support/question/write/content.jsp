<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-12 support-question-write-col-lg">
<form id="support-question-write-form" method="POST" action="<c:url value="/support/question"/>">
	<div class="panel panel-default">
		<div class="panel-heading">
			<p>서비스를 이용하시면서 불편한 사항이 있는 경우 언제든지 알려주세요.</p>
			<p>이외 궁금하신 사항을 빠르고 정확하게 알려드립니다.</p>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="support-question-write-question-title">문의 제목</label>
				<input name="title" maxlength="40" data-toggle="tooltip-title" data-placement="bottom" title="제목을 입력하셔야 돼요!" type="text" class="form-control" id="support-question-write-question-title" placeholder="여기에 제목을 입력해주세요. 최대 40글자까지 입력 가능합니다.">
			</div>
			<div class="form-group">
				<label for="support-question-write-content">문의하실 내용</label>
				<textarea name="content" data-toggle="tooltip-content" data-placement="bottom" title="내용이 없으면 도와드리기 어려워요.." cols="40" rows="12" class="form-control" id="support-question-write-content" placeholder="여기에 내용을 입력해주세요."></textarea>
			</div>
			<div class="form-group">
				<label for="support-question-write-input-file">파일 첨부</label>
				<input type="file" id="support-question-write-input-file">
			</div>
		</div>
		<div class="panel-footer">
			<div class="row support-question-write-guide">
				<div class="col-xs-9 support-question-write-guide-message">
					<p>문의하신 내용은 서비스 개선을 위해 수능라떼팀이 보관합니다.</p>
					<p>명확하지 않은 질문에 대해선 올바른 답변이 어려울 수 있습니다.</p>
				</div>
				<div class="col-xs-3 support-question-write-btn-align-right">
					<input type="submit" name="test-value" class="btn btn-default" id="support-question-write-submit" value="완료">
				</div>
			</div>
		</div>
	</div>
</form>
</div>