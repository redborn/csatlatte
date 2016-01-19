<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.password-write {font-size:13px; height:290px;}
	.password-write-content {margin-left:30px;}
	.password-write-button-group {text-align:right; width:auto;}
	.progress-bar {width:25%;}
	.progress-step {border-left:2px solid white;}
	.progress-bar-warning {background-image:linear-gradient(to bottom,#dddddd 0,#dddddd 100%);}
</style>
<script>
	$(document).ready(function () {
		$('#password-write-btn-success').attr("disabled", true);
		
		$('#password-write-content-id').on("keyup", function () {
			if ($(this).val() !== "") {
				$('#password-write-btn-success').attr("disabled", false);
			} else {
				$('#password-write-btn-success').attr("disabled", true);
			}
		});
		
		$("#password-write-form").on("submit", function() {
			var result = false;
			
			if ($('#password-write-content-id').val() !== "") {
				result = true;
			}
			
			return result;
		});
	});
</script>