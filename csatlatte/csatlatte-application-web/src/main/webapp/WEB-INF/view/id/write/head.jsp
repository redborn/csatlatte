<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.id-write {font-size:13px; height:290px;}
	.id-write-content {margin-left:30px;}
	.id-write-button-group {text-align:right; width:auto;}
	.progress-bar {width:33%;}
	.progress-final {width:34%; border-left:2px solid white;}
	.progress-step {border-left:2px solid white;}
	.progress-bar-warning {background-image:linear-gradient(to bottom,#dddddd 0,#dddddd 100%);}
</style>
<script>
	$(document).ready(function () {
		
		$('#btn-next').attr("disabled", true);
		
		$('#id-write-content-nickname').on("keyup", function () {
			if ($(this).val() !== "") {
				$('#btn-next').attr("disabled", false);
			} else {
				$('#btn-next').attr("disabled", true);
			}
		});
		
		$("#id-write-form").on("submit", function() {
			var result = false;
			
			if ($('#id-write-content-nickname') !== "") {
				result = true;
			}
			
			return result;
		});
	});
</script>