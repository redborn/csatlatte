<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.profile-question-detail-content {width:auto; border-radius:4px; border:1px solid #DDD; padding:10px; min-height:100px;}
	.profile-question-detail-answer {width:auto; border-radius:4px; border:1px solid #DDD; padding:10px; min-height:100px;}
	.profile-question-detail-btn {text-align:right;}
	.profile-question-detail-btn-group {text-align:right;}
</style>
<script>
	$(document).ready(function () {
		var qnaSequence = $('#profile-question-detail-qna-sequence').val();
		var studentId = $('#profile-question-detail-id').val();
		$('#profile-question-detail-delete-accept').on("click", function () {
			$.ajax(contextPath + "/" + studentId + "/question/" + qnaSequence + ".json", {
				dataType : "json",
				type : "DELETE",
				data : {_method : "DELETE"},
				success : function () {
					$(location).attr('href', contextPath + "/" + studentId + "/question");
				}
			});
		});
	});
</script>