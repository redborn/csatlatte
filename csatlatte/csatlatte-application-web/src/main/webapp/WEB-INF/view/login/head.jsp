<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
html, body {height:100%;}
body {margin:0;}
body > :nth-child(2) {padding-top:0;}
#login-login {width:270px; height:100%;}
#login-login > div {display:table; height:100%; width:100%;}
#login-login > div > div {display:table-cell; vertical-align:middle;}
.login-account {width:100%; margin:0 auto; text-align:center;}
.login-join {display:inline-block; width:29%; text-align:left;}
.login-find {display:inline-block; width:69%; text-align:right;}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login-form").find("input[name='id']").focus();
		
		$("#login-form").on("submit", function() {
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