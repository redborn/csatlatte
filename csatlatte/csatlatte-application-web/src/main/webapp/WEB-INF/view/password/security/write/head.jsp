<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.password-security-write-question {margin-top:7px;}
	.password-security-write {font-size:13px; height:290px;}
	.password-security-write-button-group {text-align:right; width:auto;}
	.password-security-write-content-value {display:inline-block;}
	.progress-bar {width:25%;}
	.progress-step {border-left:2px solid white;}
	.progress-bar-warning {background-image:linear-gradient(to bottom,#dddddd 0,#dddddd 100%);}
</style>
<script>
	$(document).ready(function () {
		$('#password-security-write-btn-success').attr("disabled", true);
		
		$('#password-security-write-content-answer').on("keyup", function () {
			if ($(this).val() !== "") {
				$('#password-security-write-btn-success').attr("disabled", false);
			} else {
				$('#password-security-write-btn-success').attr("disabled", true);
			}
		});
		
		$('#password-security-write-form').on("submit", function () {
			var result = false;
			
			if ($('#password-security-write-content-answer').val() !== "") {
				result = true;
			}
			
			return result;
		});
	});
</script>