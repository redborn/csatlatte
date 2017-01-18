<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.randomsolving-result-text {margin-bottom:15px;}
	.randomsolving-result-wrong-answer {position:absolute; margin-left:-35px; margin-top:-35px;}
	.randomsolving-result-correct-answer {position:absolute; margin-left:-35px; margin-top:-25px;}
	.randomsolving-result-reply {margin-top:5px; margin-bottom:5px;}
	.randomsolving-result-reply-select {color:#337ab7;}
	.randomsolving-result-reply-correct-answer {color:#a94442;}
	.randomsolving-result-solution {border:1px solid black; padding:10px; margin-bottom:15px;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var imageCount = $(".solving-list-image").length;
	for (var index = 0; index < imageCount; index++) {
		$(".solving-list-image").eq(index).attr("src", contextPath + $(".solving-list-image").eq(index).attr("src"));
	}
});
</script>