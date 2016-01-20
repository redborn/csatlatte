<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#manage-question-answer-textarea {resize:none; padding-top:5px; margin-bottom:10px; display:block; width:100%; height:150px;}
	.modal-body h5 {display:inline-block;}
	.manage-question-nav {text-align:center;}
	#manage-question-table {margin-top:15px; text-align:center;}
	.manage-question-col-lg {float:none; display:inline-block; text-align:center;}
	.manage-question-search {text-align:right; width:auto;}
	.manage-question-yn h5 {display:inline-block;}
	.manage-question-yn .btn-default {width:auto; display:inline-block;}
	.manage-question-btn-cancel {cursor:pointer;}
	.manage-question-btn-accept {cursor:pointer;}
	.manage-question-btn-group {margin-left:5px;}
	.manage-question-qna-title-content {display:inline-block; margin-left:10px;}
	.manage-question-qna-answer {margin-top:10px;}
	.manage-question-detail {text-align:right;}
	.manage-question-detail-content {text-align:left; margin-bottom:15px;}
	.manage-question-answer-accept {margin-left:10px;}
	.manage-question-form-group {text-align:left;}
	.manage-question-content-count {text-align:right;}
</style>
<script>
	$(document).ready(function () {
		
		var target;
		var answerCount;
		
		var makeQuestionDetailView = function(question) {
			var html = '';
			html += '<div class="manage-question-detail">';
			html += '	<div class="modal-body">';
			html += '		<div class="manage-question-detail-content">';
			html += '			<div class="form-group manage-question-form-group">';
			html += '				<label>질문제목</label>';
			html += '				<div>' + question.title + '</div>' 
			html += '			</div>';
			html += '			<div class="form-group manage-question-form-group">';
			html += '				<label>질문내용</label>';
			html += '				<div>' + question.content + '</div>';
			html += '			</div>';
			html += '		</div>';
			if (question.answerContent != "") {
				html += '	<div class="form-group manage-question-form-group">';
				html += '		<label>답변내용</label>';
				html += '		<div>' + question.answerContent + '</div>'; 
				html += '	</div>';
				html += '</div>';
			} else {
				html += '	<div class="form-group manage-question-form-group">';
				html += '		<label for="manage-question-answer-textarea">답변내용</label>';
				html += '		<textarea maxlength="2000" data-toggle="tooltip-answer-textarea" data-placement="bottom" title="내용이 올바르지 않습니다." id="manage-question-answer-textarea" class="form-control manage-question-answer-textarea" placeholder="답변이 완료되지 않은 문의입니다. 답변을 입력해주세요."/>';
				html += '	</div>';
				html += '	<div class="manage-question-content-count">';
				html += '		<div class="manage-question-answer-count">';
				html += '			2000';
				html += '		</div>';
				html += '	</div>';
				html += '</div>';
				html += '<div class="modal-footer">';
				html += '<input type="submit" class="btn btn-default"  data-dismiss="modal" aria-label="Close" value="닫기">';
				html += '<input type="submit" class="btn btn-primary manage-question-answer-accept" value="완료">';
				html += '</div>';
			}
			html += '</div>';
			return html;
		}
		
		var changeToViewButton = function () {
			var html = '';
			html += '<button id="' + target + '" data-toggle="modal" data-target="#manage-question-answer-view" class="manage-question-answer btn btn-default">확인</button>';
			return html;
		}
		
		var makeAnswerCount = function (answerCount) {
			var html = '';
			html += '<div class="manage-question-answer-count">';
			html += 	answerCount;
			html += '</div>';
			return html;
		}
		
		$('.manage-question-answer-view').on("click", function () {
			target = $(this).attr("id");
			$.ajax("<c:url value="/data/question.json"/>", {
				dataType : "json",
				type : "GET",
				data : {qnaSequence : target},
				success : function(data) {
					if (data.detail != null) {
						var question = data.detail;
						$("#manage-question-detail").append(makeQuestionDetailView(question));
						$('#manage-question-answer-textarea').on("keyup", function () {
							answerCount = 2000 - $('#manage-question-answer-textarea').val().length;
							$('.manage-question-answer-count').remove();
							$('.manage-question-content-count').append(makeAnswerCount(answerCount));
						});
						$('.manage-question-answer-accept').on("click", function () {
							if ($('.manage-question-answer-textarea').val() !== "") {
								var answerContent = $('.manage-question-answer-textarea').val().replace(/\n/g, '<br>');
								$.ajax("<c:url value="/data/manage/question.json"/>", {
									dataType : "json",
									type : "POST",
									data : {qnaSequence : target, answerContent : answerContent},
									success : function () {
										$('#manage-question-answer-button-div-' + target).remove();
										$('#manage-question-answer-button-' + target).append(changeToViewButton());
										$('.manage-question-detail').remove();
										$.ajax("<c:url value="/data/question.json"/>", {
											dataType : "json",
											type : "GET",
											data : {qnaSequence : target},
											success : function(data) {
												if (data.detail != null) {
													var question = data.detail;
													$("#manage-question-detail").append(makeQuestionDetailView(question));
												}
											}
										});
										$('#' + target).on("click", function () {
											target = $(this).attr("id");
											$.ajax("<c:url value="/data/question.json"/>", {
												dataType : "json",
												type : "GET",
												data : {qnaSequence : target},
												success : function(data) {
													if (data.detail != null) {
														var question = data.detail;
														$("#manage-question-detail").append(makeQuestionDetailView(question));
													}
												}
											});
										});
									}
								});
							} else {
								$('[data-toggle="tooltip-answer-textarea"]').tooltip('show');
								setTimeout(function () {
									$('[data-toggle="tooltip-answer-textarea"]').tooltip('destroy');
								}, 1500);
							}
						});
					}
				}
			});
		});
		
		$('#manage-question-answer-view').on('hidden.bs.modal', function () {
			$('.manage-question-detail').remove();
		});
		
	});
</script>