<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.profile-question-detail-content {width:auto; border-radius:4px; border:1px solid #DDD; padding:10px; min-height:100px;}
	.profile-question-detail-answer {width:auto; border-radius:4px; border:1px solid #DDD; padding:10px; min-height:100px;}
	.profile-question-detail-btn {text-align:right;}
	.profile-question-detail-btn-group {text-align:right;}
	#profile-question-detail-delete-form {display:inline-block;}
	.profile-question-detail-content xmp {white-space:pre-wrap; word-break:break-all;}
	.profile-question-detail-answer xmp {white-space:pre-wrap; word-break:break-all;}
	.profile-question-detail-files .col-lg-2 {white-space:nowrap; width:150px; text-overflow:ellipsis; overflow:hidden;}
</style>