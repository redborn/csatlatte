<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.support-col-lg {float:none; padding:0px;}
	#support-content {padding:0px;}
	.support-question {width:100%; padding:15px; background:#d7d0cb; border-bottom:1px solid #7a6253; cursor:pointer;}
	.support-answer {width:100%; background: #e8e4e1; padding: 15px; display:none;}
	.support-guide .support-guide-message {font-size:13px;}
	.support-guide .support-btn-align-right {text-align:right;}
</style>
<script>
	$(document).ready(function () {
		
		$(".support-question").on("click", function () {
			$(".support-answer").eq($(".support-question").index($(this))).slideToggle("fast");
		});
	});
</script>