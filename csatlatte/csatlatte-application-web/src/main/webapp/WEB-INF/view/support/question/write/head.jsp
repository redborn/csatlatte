<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	.panel {width:933px; margin:auto;}
	.panel-heading {background:white;}
	#support-question-write-content {width:100%; resize:none;}
	.support-question-write-guide {position:relative;}
	.support-question-write-guide .support-question-write-guide-message {font-size:13px; width:825px; display:inline-block;}
	.support-question-write-guide .support-question-write-btn-align-right {margin-top:3px; display:inline-block; width:70px; text-align:right; vertical-align:top;}
</style>
<script>
	$(document).ready(function () {
		
		$("#support-question-write-form").on("submit", function() {
			var result = false;
			
			if ($("#support-question-write-title").val() == "") {
				$('[data-toggle="tooltip"]').tooltip('show'); 	
			}
			
			if ($("#support-question-write-content").val() == "") {
				$('[data-toggle="tooltip"]').tooltip('show');
			}
			
			if ($("#support-question-write-title").val() != "" && $("#support-question-write-content").val() != "") {
				result = true;
			}
				
			return result;
		});
		
	});
</script>