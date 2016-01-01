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
		
		var pageNumber = null;
		var search = null;
		var useYn = null;
		var target = null;
		
		var getUrlParameter = function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;

		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};
		
		var makeQuestionDataRow = function(question) {
			var html = '';
			html += '<tr class="manage-question-data-row">';
			html += '	<td>' + question.qnaSequence + '</td>';
			html += '	<td>' + question.studentId + '</td>';
			html += '	<td>' + question.nickname + '</td>';
			html += '	<td><div id="'+ question.qnaSequence +'" data-toggle="modal" data-target="#manage-question-answer-view" class="manage-question-answer-view">' + question.title + '</div></td>';
			html += '	<td>' + question.writeDate + '</td>';
			html += '	<td>' + question.useYn + '</td>';
			html += '</tr>';
			return html;
		}
		
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
		
		pageNumber = getUrlParameter('pageNumber');
		search = getUrlParameter('search');
		
		$.ajax("<c:url value="/data/manage/question.json"/>", {
			dataType : "json",
			type : "GET",
			data : {pageNumber : pageNumber, search : search, useYn : useYn},
			success : function(data) {
				if (data.list != null) {
					questionList = data.list;
					questionListLength = questionList.length;
					for (index = 0; index < questionListLength; index++) {
						question = questionList[index];
						$("#table-content").append(makeQuestionDataRow(question));
						console.log("데이터가 추가되었습니다."	);
					}
					$(".manage-question-answer-view").on("click", function () {
						console.log("manage-question-answer-view 클릭 했습니다.");
						var qnaSequence = $(this).attr("id");
						target = qnaSequence;
						$.ajax("<c:url value="/data/question.json"/>", {
							dataType : "json",
							type : "GET",
							data : {qnaSequence : qnaSequence},
							success : function(qnaData) {
								if (qnaData.detail != null) {
									question = qnaData.detail;
									$("#manage-question-detail").append(makeQuestionDetailView(question));
								}
								$(".manage-question-answer-accept").on("click", function () {
								var answerContent = $('.manage-question-answer-textarea').val();
									$.ajax("<c:url value="/data/manage/question.json"/>", {
										dataType : "json",
										type : "POST",
										data : {qnaSequence : target, answerContent : answerContent},
										success : function() {
											alert("답변이 완료되었습니다.");
										}
									});
								});
							}
						});
					});
				}
			}
		});
		
		$("#manage-question-all").on("click", function () {
			$('.manage-question-data-row').remove();
			useYn = null;
			$.ajax("<c:url value="/data/manage/question.json"/>", {
				dataType : "json",
				type : "GET",
				data : {pageNumber : pageNumber, search : search, useYn : useYn},
				success : function(data) {
					if (data.list != null) {
						questionList = data.list;
						questionListLength = questionList.length;
						for (index = 0; index < questionListLength; index++) {
							question = questionList[index];
							$("#table-content").append(makeQuestionDataRow(question));
						}
						$(".manage-question-answer-view").on("click", function () {
							var qnaSequence = $(this).attr("id");
							$.ajax("<c:url value="/data/question.json"/>", {
								dataType : "json",
								type : "GET",
								data : {qnaSequence : qnaSequence},
								success : function(qnaData) {
									if (qnaData.detail != null) {
										question = qnaData.detail;
										$("#manage-question-detail").append(makeQuestionDetailView(question));
									}
								}
							});
						});
					}
				}
			});
		});
		
		$("#manage-question-standby").on("click", function () {
			$('.manage-question-data-row').remove();
			useYn = "Y";
			$.ajax("<c:url value="/data/manage/question.json"/>", {
				dataType : "json",
				type : "GET",
				data : {pageNumber : pageNumber, search : search, useYn : useYn},
				success : function(data) {
					if (data.list != null) {
						questionList = data.list;
						questionListLength = questionList.length;
						for (index = 0; index < questionListLength; index++) {
							question = questionList[index];
							$("#table-content").append(makeQuestionDataRow(question));
						}
						$(".manage-question-answer-view").on("click", function () {
							var qnaSequence = $(this).attr("id");
							$.ajax("<c:url value="/data/question.json"/>", {
								dataType : "json",
								type : "GET",
								data : {qnaSequence : qnaSequence},
								success : function(qnaData) {
									if (qnaData.detail != null) {
										question = qnaData.detail;
										$("#manage-question-detail").append(makeQuestionDetailView(question));
									}
								}
							});
						});
					}
				}
			});
		});
		
		$("#manage-question-success").on("click", function () {
			$('.manage-question-data-row').remove();
			useYn = "N";
			$.ajax("<c:url value="/data/manage/question.json"/>", {
				dataType : "json",
				type : "GET",
				data : {pageNumber : pageNumber, search : search, useYn : useYn},
				success : function(data) {
					if (data.list != null) {
						questionList = data.list;
						questionListLength = questionList.length;
						for (index = 0; index < questionListLength; index++) {
							question = questionList[index];
							$("#table-content").append(makeQuestionDataRow(question));
						}
						$(".manage-question-answer-view").on("click", function () {
							var qnaSequence = $(this).attr("id");
							$.ajax("<c:url value="/data/question.json"/>", {
								dataType : "json",
								type : "GET",
								data : {qnaSequence : qnaSequence},
								success : function(qnaData) {
									if (qnaData.detail != null) {
										question = qnaData.detail;
										$("#manage-question-detail").append(makeQuestionDetailView(question));
									}
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
		
	});
</script>