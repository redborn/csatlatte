<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#support-question-write-content {width:100%; resize:none;}
	.support-question-write-guide {position:relative;}
	.support-question-write-guide .support-question-write-guide-message {font-size:13px;}
	.support-question-write-guide .support-question-write-btn-align-right {text-align:right; margin-top:3px;}
	.support-question-write-col-lg {float:none;}
</style>
<script>
	$(document).ready(function () {
		
		var titleKeyup = false;
		var contentKeyup = false;
		
		$('#support-question-write-submit').attr('disabled',true);
		
		$('#support-question-write-question-title').on("keyup", function () {
			titleKeyup = true;
			
			$('#support-question-write-submit').attr('disabled',true);
			
			if ($("#support-question-write-question-title").val() == "") {
				titleKeyup = false; 	
			}
			
			if (titleKeyup && contentKeyup) {
				$('#support-question-write-submit').attr('disabled',false);
			}
		});
		
		$('#support-question-write-content').on("keyup", function () {
			contentKeyup = true;
			
			$('#support-question-write-submit').attr('disabled',true);
			
			if ($("#support-question-write-content").val() == "") {
				contentKeyup = false;
			}
			
			if (titleKeyup && contentKeyup) {
				$('#support-question-write-submit').attr('disabled',false);
			}	
		});
		
		$("#support-question-write-form").on("submit", function() {
			var result = false;
			
			if ($("#support-question-write-question-title").val() == "") {
				$('[data-toggle="tooltip-title"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-title"]').tooltip('destroy');
				}, 2000);
			}
			
			if ($("#support-question-write-content").val() == "") {
				$('[data-toggle="tooltip-content"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-content"]').tooltip('destroy');
				}, 2000);
			}
			
			if ($("#support-question-write-question-title").val() != "" && $("#support-question-write-content").val() != "") {
				result = true;
			}
				
			if (result) {
				var title = $('#support-question-write-question-title').val();
				var content = $('#support-question-write-content').val();
				$.ajax(contextPath + "/data/question.json", {
					dataType : "json",
					type : "POST",
					data : {title : title, content : content},
					success : function () {
						
					}
				});
			}
			
			return result;
		});
	});
</script>