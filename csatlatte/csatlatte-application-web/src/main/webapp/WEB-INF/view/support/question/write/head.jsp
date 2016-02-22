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
	#support-question-write-file-message {color:#d9534f; margin-left:10px; display:none;}
	.support-question-write-file-div {margin : 4px 0;}
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
		
		var setInputFileEvent = function(index) {
			$(".support-question-write-file-minus").eq(index).on("click", function() {
				$(".support-question-write-file-div").eq($(".support-question-write-file-minus").index(this)).slideUp("fast", function() {
					$(this).remove();
				});
				if ($(".support-question-write-file-div").size() <= 5) {
					$("#support-question-write-file-plus").slideDown("fast");
				}
			});
			
			$("#support-question-write-form input[type='file']").eq(index).on("change", function() {
				var data = this;
				if (data) {
					var files = data.files;
					if (files && files[0]) {
						var file = files[0];
						console.log(file);
						if (file.size >= 1000000) {
							$(".support-question-write-file-div").eq(index).slideUp("fast", function() {
								$(this).remove();
							});
							$("#support-question-write-file-message").fadeIn("fast", function() {
								setTimeout(function() {
									$("#support-question-write-file-message").fadeOut("fast");
								}, 5000);
							});
						} else {
							$(".support-question-write-file-name").eq(index).text(file.name);
						}
					}
				}
			});
		};
		
		setInputFileEvent(0);
		
		$("#support-question-write-file-plus").on("click", function() {
			var size = $(".support-question-write-file-div").size();
			if (size <= 4) {
				var html = '<div class="support-question-write-file-div" style="display:none;">';
				html += '	<span class="btn btn-default fileinput-button">';
				html += '		<span>파일 선택</span>';
				html += '		<input type="file" name="file" class="support-question-write-input-file"/>';
				html += '	</span>';
				html += '	<span class="btn btn-default support-question-write-file-minus"><i class="glyphicon glyphicon-minus"></i></span>';
				html += '	<span class="support-question-write-file-name"></span>';
				html += '</div>';
				var $html = $(html);
				$(this).before($html);
				$html.slideDown("fast");
				
				setInputFileEvent(size);
				
				if (size == 4) {
					$("#support-question-write-file-plus").slideUp("fast");
				}
			}
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