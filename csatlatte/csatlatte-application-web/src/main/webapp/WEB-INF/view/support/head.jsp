<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.support-col-lg {float:none; padding:0px;}
	#support-content {padding:0px;}
	.support-question {width:100%; height:50px; background:#d7d0cb; padding:15px; border-bottom:1px solid #7a6253; cursor:pointer;}
	.support-answer {width:100%; background: #e8e4e1; padding: 15px; display:none;}
	.support-guide .support-guide-message {font-size:13px;}
	.support-guide .support-btn-align-right {text-align:right;}
</style>
<script>
	$(document).ready(function () {
		
		$(".support-question").on("click", function () {
			$(".support-answer").eq($(".support-question").index($(this))).slideToggle("fast");
		});
		
		var makeFaqList = function (faq) {
			var html = '';
			html += '<div class="support-faq">';
			html += '	<div class="support-question"><p><strong>' + faq.title + '</strong></p></div>';
			html += '	<div class="support-answer">' + faq.content + '</div>';
			html += '</div>';
			return html;
		}
		
		$.ajax(contextPath + "/data/support.json", {
			dataType : "json",
			type : "GET",
			data : {faqTypeSequence : 1},
			success : function (data) {
				if (data.list != null) {
					var faqList = data.list;
					var faqListLength = faqList.length;
					for (var index = 0; index < faqListLength; index++) {
						var faq = faqList[index];
						$('#support-content').append(makeFaqList(faq));
					}
					$(".support-question").on("click", function () {
						$(".support-answer").eq($(".support-question").index($(this))).slideToggle("fast");
					});
				}
			}
		});
		
		$("#support-category").on("change", function () {
			var faqTypeSequence = $(this).val();
			$.ajax(contextPath + "/data/support.json", {
				dataType : "json",
				type : "GET",
				data : {faqTypeSequence : faqTypeSequence},
				success : function(data) {
					$('.support-faq').remove();
					if (data.list != null) {
						var faqList = data.list;
						var faqListLength = faqList.length;
						for (var index = 0; index < faqListLength; index++) {
							var faq = faqList[index];
							$('#support-content').append(makeFaqList(faq));
						}
						$(".support-question").on("click", function () {
							$(".support-answer").eq($(".support-question").index($(this))).slideToggle("fast");
						});
					}
				}
			});
		});
	});
</script>