<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.form-control {width:20%; float:none;}
	.panel {width:933px; margin:auto;}
	.dropdown {display:inline;}
	.panel-heading {background:white;}
	.panel-body {padding:0px;}
	.support-question {width:100%; height:50px; background:#d7d0cb; padding:15px; border-bottom:1px solid #7a6253; cursor:pointer;}
	.support-answer {width:100%; background: #e8e4e1; padding: 15px; display:none;}
	.support-guide .support-guide-message {font-size:13px; width:89%; display:inline-block;}
	.support-guide .support-btn-align-right {width:70px; display:inline-block; text-align:right; vertical-align:top; margin-top:3px;}
</style>
<script>
	$(document).ready(function () {
		$(".support-question").on("click", function () {
			$(".support-answer").eq($(".support-question").index($(this))).slideToggle("fast");
		});
		
		$("#support-category").on("change", function() {
			$(location).attr('href', '<c:url value="/support?faqTypeSequence="/>' + $(this).val());
		});
	});
</script>