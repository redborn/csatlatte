<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<%@ include file="/WEB-INF/layout/include/jquery/form.jsp" %>
<style>
	html {height:100%;}
	body {height:100%; margin:0;}
	.main-picture {width:100%; height:100%;
		background: url("${pageContext.request.contextPath}/resources/csatlatte/images/header/bg_main4_smallest.jpg") no-repeat center center fixed;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
	}
	.main-title {font-size:40px; text-shadow:rgb(110,110,110) 0px 0px 8px; color:white; position: absolute; top: 50%; margin-top: -187px; width: 100%; text-align:center;}
	.main-login {position:absolute; top:50%; width:270px; left:50%; margin-left:-135px; margin-top:-50px; color:white; text-align:center;}
	.main-login .btn {background:#7a6253; width:100%; color:white; border-color:#7a6253;}
	.main-login .main-join {width:28%; display:inline-block;}
	.main-login .main-find-info {width:70%; display:inline-block; text-align:right;}
	#main-maintain-login {text-align:left;}
	.main-profile-photo {width:120px; height:120px; border-radius:4px; border:1px solid white;}
	.main-link {color:white; text-shadow:rgb(110,110,110) 0px 0px 6px;}
	.main-link:hover {color:white;}
	@media (min-width: 768px) {
		.main-picture {width:100%; height:100%;
			background: url("${pageContext.request.contextPath}/resources/csatlatte/images/header/bg_main4_small.jpg") no-repeat center center fixed;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
	}
	@media (min-width: 992px) {
		.main-title {padding-right:65%; margin-top:-57px;}
		.main-login {left:82%; margin-top:-81px;}
		.main-picture {width:100%; height:100%;
			background: url("${pageContext.request.contextPath}/resources/csatlatte/images/header/bg_main4_medium.jpg") no-repeat center center fixed;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
	}
	@media (min-width: 1200px) {
		.main-picture {width:100%; height:100%;
			background: url("${pageContext.request.contextPath}/resources/csatlatte/images/header/bg_main4_large.jpg") no-repeat center center fixed;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
	}
	
</style>
<session:isGuest>
<script type="text/javascript">
	$(document).ready(function() {
		$("#main-form").find("input[name='id']").focus();
		
		$("#main-form").on("submit", function() {
			var $form = $(this);
			var result = false;
			var makeTooltip = function($selector, title, placement) {
				$selector.tooltip({
					title : title,
					placement : placement
				});
				$selector.focus();
				setTimeout(function() {
					$selector.tooltip("hide");
				}, 5000);
			};
			
			if ($.trim($form.find("input[name='id']").val()) === "") {
				makeTooltip($form.find("input[name='id']"), "아이디를 입력하세요.", "bottom");
			} else if ($.trim($form.find("input[name='password']").val()) === "") {
				makeTooltip($form.find("input[name='password']"), "비밀번호를 입력하세요.", "bottom");
			} else {
				result = true;
			}
			return result;
		});
	});
</script>
</session:isGuest>