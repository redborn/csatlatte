<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	nav {text-align:center;}
	th {text-align:center;}
	tr {text-align:center;}
	.table {margin-top:15px;}
	
	.col-lg-4 {float:none; display:inline-block;}
	.manage-community-search {text-align:right;}

	.manage-question-title {display:inline-block; width:380px;}
	.manage-question-yn h5 {display:inline-block;}
	.manage-question-yn .btn-default {width:auto; display:inline-block;}
	.manage-question-btn-cancel {cursor:pointer;}
	.manage-question-btn-accept {cursor:pointer;}
	.manage-question-content {cursor:pointer;}
	.btn-group {margin-left:5px;}
	
	.modal-body h5 {display:inline-block;}
	.manage-question-qna-title-content {display:inline-block; margin-left:10px;}
	.manage-question-qna-answer {margin-top:10px;}
	
	textarea {resize:none; border:none; padding-top:5px; margin-bottom:10px;}
	textarea.form-control {display:block; width:100%; height:150px;}
	
	.manage-question-detail {text-align:right;}
	.manage-question-detail-content {text-align:left; margin-bottom:15px;}
	.manage-question-detail-answer {text-align:left;}
</style>
<script>
	$(document).ready(function () {
		
		var makeQuestionDetailView = function(question) {
			var html = '';
			html += '<div class="manage-question-detail">';
			html += '	<div class="manage-question-detail-content">';
			html += '		<div><b>질문제목</b> : ' + question.title + '</div>';
			html += '		<div><b>질문내용</b> : ' + question.content + '</div>';
			html += '	</div>';
			if (question.answerContent != "") {
				html += '<div class="manage-question-detail-answer"><b>답변내용</b> : ' + question.answerContent + '</div>';
			} else {
				html += '<textarea class="form-control manage-question-answer-textarea" placeholder="답변이 완료되지 않은 문의입니다. 답변을 입력해주세요."/>';
				html += '<input type="submit" class="btn btn-primary manage-question-answer-accept" value="답변완료">';
			}
			html += '</div>';
			return html;
		}
		
		$('.manage-question-answer-view').on("click", function () {
			var target = $(this).attr("id");
			$.ajax("<c:url value="/data/question.json"/>", {
				dataType : "json",
				type : "GET",
				data : {qnaSequence : target},
				success : function(data) {
					if (data.detail != null) {
						var question = data.detail;
						$("#manage-question-detail").append(makeQuestionDetailView(question));
						$('.manage-question-answer-accept').on("click", function () {
							var answerContent = $('.manage-question-answer-textarea').val();
							$.ajax("<c:url value="/data/manage/question.json"/>", {
								dataType : "json",
								type : "POST",
								data : {qnaSequence : target, answerContent : answerContent},
								success : function () {
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
								}
							});
						});
					}
				}
			});
		});
		
		$('#manage-question-answer-view').on('hidden.bs.modal', function () {
			$('.manage-question-detail').remove();
		});
		
		$('#manage-question-all').on("click", function () {
			$(location).attr('href', '<c:url value="/manage/question"/>');	
		});
		
		$('#manage-question-standby').on("click", function () {
			$(location).attr('href', '<c:url value="/manage/question?useYn="/>' + "Y");	
		});
		
		$('#manage-question-success').on("click", function () {
			$(location).attr('href', '<c:url value="/manage/question?useYn="/>' + "N");	
		});
		
		$('#manage-question-search').on("keyup", function (event) {
			if (event.which == 13) {
				var search = $('#manage-question-search').val();
				$(location).attr('href', '<c:url value="/manage/question?search="/>' + search);
			}
		});
	});
</script>