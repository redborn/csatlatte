<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/banner/250x250.jsp" %>
<style>
	.profile-authentication {font-size:13px; height:340px;}
	.profile-authentication-content {margin-left:30px;}
	.profile-authentication-message {text-align:center;}
	.profile-authentication-button-group {text-align:right; width:auto;}
</style>
<script>
	$(document).ready(function () {
		$('#profile-authentication-btn-success').attr("disabled",true);
		
		$('#profile-authentication-content-password').on("keyup", function () {
			if ($(this).val() !== "") {
				$('#profile-authentication-btn-success').attr("disabled",false);
			} else {
				$('#profile-authentication-btn-success').attr("disabled",true);
			}
		});
	});
</script>