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
	
	textarea {resize:none; border:none; padding-top:5px;}
	textarea.form-control {display:block; width:100%; height:150px;}
</style>
<script>
	$(document).ready(function () {
		$("#manage-question-all").on("click", function () {
			$(location).attr('href', '<c:url value="/manage/question"/>');
		});
		
		$("#manage-question-standby").on("click", function () {
			$(location).attr('href', '<c:url value="/manage/question?useYn=Y"/>');
		});
		
		$("#manage-question-success").on("click", function () {
			$(location).attr('href', '<c:url value="/manage/question?useYn=N"/>');
		});
	});
</script>