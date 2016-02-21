<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/jquery/fileupload.jsp" %>
<style>
	#support-question-write-content {width:100%; resize:none;}
	.support-question-write-guide {position:relative;}
	.support-question-write-guide .support-question-write-guide-message {font-size:13px;}
	.support-question-write-guide .support-question-write-btn-align-right {text-align:right; margin-top:3px;}
	.support-question-write-col-lg {float:none;}
	#support-question-write-input-minus {display:none;}
	#support-question-write-input-message {color:#d9534f; margin-top:5px;}
	#support-question-write-file-list {margin-bottom:5px;}
</style>
<script>
	$(document).ready(function () {
		
		var titleKeyup = false;
		var contentKeyup = false;
		
		var makeFileList = function (fileValue) {
			var html = '';
			html += '<div class="support-question-write-file-resource">';
			html += '<p>' + fileValue + '</p>';
			html += '</div>';
			return html;
		}
		
		var inputFile = $("#support-question-write-form input[type='file']");
		$("#support-question-write-form input[type='file']").on("change", function() {
			var data = this;
			if (data) {
				var files = data.files;
				if (files && files[0]) {
					var file = files[0];
					if (file.size >= 1000000) {
						$("#support-question-write-input-message").text("파일 크기는 10MB 이하만 사용할 수 있습니다.").show();
						$("#support-question-write-input-minus").trigger("click");
					} else {
						$("#support-question-write-input-message").hide();
						var reader = new FileReader();
						reader.onload = function (e) {
							$(".support-question-write-file-resource").remove();
							$("#support-question-write-file-list").append(makeFileList($("#support-question-write-input-file").val()));
							$("#support-question-write-input-minus").fadeIn("fast").css("display", "inline-block");
						}
						reader.readAsDataURL(file);
					}
				}
			}
		});
		$("#support-question-write-input-minus").on("click", function () {
			inputFile.replaceWith(inputFile.clone(true));
			$(".support-question-write-file-resource").remove();
			$(this).fadeOut("fast");
		});
		
		$('#support-question-write-submit').attr('disabled',true);
		
		$('#support-question-write-question-title').on("keyup", function () {
			titleKeyup = true;
			
			$('#support-question-write-submit').attr('disabled',true);
			
			if ($("#support-question-write-question-title").val() === "") {
				titleKeyup = false; 	
			}
			
			if (titleKeyup && contentKeyup) {
				$('#support-question-write-submit').attr('disabled',false);
			}
		});
		
		$('#support-question-write-content').on("keyup", function () {
			contentKeyup = true;
			
			$('#support-question-write-submit').attr('disabled',true);
			
			if ($("#support-question-write-content").val() === "") {
				contentKeyup = false;
			}
			
			if (titleKeyup && contentKeyup) {
				$('#support-question-write-submit').attr('disabled',false);
			}	
		});
		
		$("#support-question-write-form").on("submit", function() {
			var result = false;
			
			if ($("#support-question-write-question-title").val() === "") {
				$('[data-toggle="tooltip-title"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-title"]').tooltip('destroy');
				}, 2000);
			}
			
			if ($("#support-question-write-content").val() === "") {
				$('[data-toggle="tooltip-content"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-content"]').tooltip('destroy');
				}, 2000);
			}
			
			if ($("#support-question-write-question-title").val() !== "" && $("#support-question-write-content").val() !== "") {
				result = true;
			}
			
			return result;
		});
	});
</script>