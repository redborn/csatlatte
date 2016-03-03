<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.id-security-write {font-size:13px; height:290px;}
	.id-security-write-content {margin-left:30px;}
	.id-security-write-message {margin-left:70px; margin-top:5px;}
	.id-security-write-question {margin-top:7px;}
	.id-security-write-button-group {text-align:right; width:auto;}
	.progress-bar {width:33%;}
	.progress-final {width:34%; border-left:2px solid white;}
	.progress-step {border-left:2px solid white;}
	.progress-bar-warning {background-image:linear-gradient(to bottom,#dddddd 0,#dddddd 100%);}
</style>
<script>
	$(document).ready(function () {
		
		$('#id-security-write-content-answer').on("keyup", function () {
			if ($(this).val() !== "") {
				$('#id-security-write-btn-success').attr("disabled", false);
			} else {
				$('#id-security-write-btn-success').attr("disabled", true);
			}
		});
		
		$('#id-security-write-form').on("submit", function () {
			var result = false;
			
			if ($('#id-security-write-content-answer').val() !== "") {
				result = true;
			}
			
			return result;
		});
	});
</script>